package sk.mirri.ootspoc.wsplugin.client;

import java.io.ByteArrayOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import javax.xml.soap.Name;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.SoapMessage;
import org.springframework.ws.soap.client.SoapFaultClientException;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.springframework.ws.soap.saaj.SaajSoapMessage;

import wsplugin.domibus.eu.GetErrorsRequest;
import wsplugin.domibus.eu.GetStatusRequest;
import wsplugin.domibus.eu.LargePayloadType;
import wsplugin.domibus.eu.ListPendingMessagesRequest;
import wsplugin.domibus.eu.ListPendingMessagesResponse;
import wsplugin.domibus.eu.MessageStatus;
import wsplugin.domibus.eu.RetrieveMessageRequest;
import wsplugin.domibus.eu.RetrieveMessageResponse;
import wsplugin.domibus.eu.SubmitRequest;
import wsplugin.domibus.eu.SubmitResponse;

public class WSPluginServiceClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(WSPluginServiceClient.class);

	public ListPendingMessagesResponse getPendingMessages() {
		final ListPendingMessagesRequest request = new ListPendingMessagesRequest();
		// log.info("Requesting wsplugin service for list of pending messages");
		final ListPendingMessagesResponse response = (ListPendingMessagesResponse) getWebServiceTemplate()
				.marshalSendAndReceive(request, new SoapActionCallback(""));
		return response;
	}

	public Object getMessageErrors(final String uuid) {
		final GetErrorsRequest request = new GetErrorsRequest();
		// TODO preco tam nie je GetMessageErrorsResponse?
		final Object response = getWebServiceTemplate().marshalSendAndReceive(request, new SoapActionCallback(""));
		return response;
	}

	public RetrieveMessageResponse retieveMessage(final String uuid) {
		final RetrieveMessageRequest request = new RetrieveMessageRequest();
		request.setMessageID(uuid);
		log.info("Requesting wsplugin service for retievie message " + uuid);
		final RetrieveMessageResponse response = (RetrieveMessageResponse) getWebServiceTemplate()
				.marshalSendAndReceive(request, new SoapActionCallback(""));
		return response;
	}

	public SubmitResponse submitRequest(final List<LargePayloadType> payload) {
		final SubmitRequest request = new SubmitRequest();
		request.getPayload().addAll(payload);
		log.info("Requesting backend service with submitRequest");

		final WebServiceTemplate webServiceTemplate = getWebServiceTemplate();
		SubmitResponse res = null;
		try {
			res = (SubmitResponse) webServiceTemplate.marshalSendAndReceive(request, message -> {
				try {

					((SoapMessage) message).setSoapAction("");
					final SaajSoapMessage saajSoapMessage = (SaajSoapMessage) message;
					final SOAPMessage soapMessage = saajSoapMessage.getSaajMessage();
					final SOAPPart soapPart = soapMessage.getSOAPPart();
					final SOAPEnvelope soapEnvelope = soapPart.getEnvelope();

					final SOAPHeader soapHeader = soapEnvelope.getHeader();
					final Name headerElementName = soapEnvelope.createName("Messaging", "ns",
							"http://docs.oasis-open.org/ebxml-msg/ebms/v3.0/ns/core/200704/");
					final SOAPHeaderElement soapHeaderElement = soapHeader.addHeaderElement(headerElementName);
					final SOAPElement userMessageSOAPElement = soapHeaderElement.addChildElement("UserMessage", "ns");
					final SOAPElement partyInfoSOAPElement = userMessageSOAPElement.addChildElement("PartyInfo", "ns");
					final SOAPElement fromSOAPElement = partyInfoSOAPElement.addChildElement("From", "ns");
					final SOAPElement partyFromOAPElement = fromSOAPElement.addChildElement("PartyId", "ns");
					partyFromOAPElement.addTextNode("sk_test_ap");
					partyFromOAPElement.setAttribute("type",
							"urn:oasis:names:tc:ebcore:partyid-type:unregistered:oots-simulator");
					final SOAPElement roleFromOAPElement = fromSOAPElement.addChildElement("Role", "ns");
					roleFromOAPElement.addTextNode("http://sdg.europa.eu/edelivery/gateway");

					final SOAPElement toSOAPElement = partyInfoSOAPElement.addChildElement("To", "ns");
					final SOAPElement partyToOAPElement = toSOAPElement.addChildElement("PartyId", "ns");
					partyToOAPElement.addTextNode("sk_test_ap");
					partyToOAPElement.setAttribute("type",
							"urn:oasis:names:tc:ebcore:partyid-type:unregistered:oots-simulator");
					final SOAPElement roleToOAPElement = toSOAPElement.addChildElement("Role", "ns");
					roleToOAPElement.addTextNode("http://sdg.europa.eu/edelivery/gateway");

					final SOAPElement collaborationInfo = userMessageSOAPElement.addChildElement("CollaborationInfo",
							"ns");
					final SOAPElement servicePElement = collaborationInfo.addChildElement("Service", "ns");
					servicePElement.addTextNode("QueryManager");
					servicePElement.setAttribute("type", "urn:oasis:names:tc:ebcore:ebrs:ebms:binding:1.0");
					final SOAPElement actionElement = collaborationInfo.addChildElement("Action", "ns");
					actionElement.addTextNode("ExecuteQueryRequest");
					final SOAPElement conversationIdElement = collaborationInfo.addChildElement("ConversationId", "ns");
					conversationIdElement.addTextNode("fedcce0a-8936-4b9e-8545-148e151d34a8");

					final SOAPElement messagePropertiesSOAPElement = userMessageSOAPElement
							.addChildElement("MessageProperties", "ns");
					final SOAPElement p1Element = messagePropertiesSOAPElement.addChildElement("Property", "ns");
					p1Element.addTextNode("urn:oasis:names:tc:ebcore:partyid-type:unregistered:C1");
					p1Element.setAttribute("name", "originalSender");

					final SOAPElement p2Element = messagePropertiesSOAPElement.addChildElement("Property", "ns");
					p2Element.addTextNode("urn:oasis:names:tc:ebcore:partyid-type:unregistered:C4");
					p2Element.setAttribute("name", "finalRecipient");

					final SOAPElement payloadInfoSOAPElement = userMessageSOAPElement.addChildElement("PayloadInfo",
							"ns");

					final List<LargePayloadType> payloads = request.getPayload();

					for (final LargePayloadType payload1 : payloads) {
						if (payload1.getContentType().equalsIgnoreCase("application/x-ebrs+xml")) {
							final SOAPElement partInfoElement1 = payloadInfoSOAPElement.addChildElement("PartInfo",
									"ns");
							partInfoElement1.setAttribute("href", "cid:regrep@oots.eu");
							final SOAPElement partPropertiesElement1 = partInfoElement1
									.addChildElement("PartProperties", "ns");
							final SOAPElement partp1Element1 = partPropertiesElement1.addChildElement("Property", "ns");
							partp1Element1.addTextNode("application/x-ebrs+xml");
							partp1Element1.setAttribute("name", "MimeType");
							final SOAPElement partp2Element1 = partPropertiesElement1.addChildElement("Property", "ns");
							partp2Element1.addTextNode("request.xml");
							partp2Element1.setAttribute("name", "PayloadName");
						}
						if (payload1.getContentType().equalsIgnoreCase("application/pdf")) {
							final SOAPElement partInfoElement2 = payloadInfoSOAPElement.addChildElement("PartInfo",
									"ns");
							partInfoElement2.setAttribute("href", "cid:evidencepdf@oots.eu");
							final SOAPElement partPropertiesElement2 = partInfoElement2
									.addChildElement("PartProperties", "ns");
							final SOAPElement partp1Element2 = partPropertiesElement2.addChildElement("Property", "ns");
							partp1Element2.addTextNode("application/pdf");
							partp1Element2.setAttribute("name", "MimeType");
							final SOAPElement partp2Element2 = partPropertiesElement2.addChildElement("Property", "ns");
							partp2Element2.addTextNode("evidence.pdf");
							partp2Element2.setAttribute("name", "PayloadName");
						}
					}

					soapMessage.saveChanges();

					final ByteArrayOutputStream out = new ByteArrayOutputStream();
					soapMessage.writeTo(out);
					final String strMsg = new String(out.toByteArray());
					final String path = "outgoing\\soap-envelope-" + new Date().getTime() + ".xml";
					Files.write(Paths.get(path), strMsg.getBytes());

					// logger.info("Marshalling of SOAP header success." + strMsg);
				} catch (final Exception e) {
					logger.error("error during marshalling of the SOAP headers", e);
				}
			});

		} catch (final SoapFaultClientException e) {
			logger.error("Error while invoking session service : ", e);
			return null;
		}

		// return res.getValue();
		return res;
	}

	// not working because of wsdl
	public MessageStatus getStatus(final String uuid) {
		final GetStatusRequest request = new GetStatusRequest();
		request.setMessageID(uuid);
		log.info("Requesting wsplugin service for status");

		final MessageStatus response = (MessageStatus) getWebServiceTemplate().marshalSendAndReceive(request,
				new SoapActionCallback(""));
		return response;
	}

	// RetrieveMessageResponse, SubmitResponse
}