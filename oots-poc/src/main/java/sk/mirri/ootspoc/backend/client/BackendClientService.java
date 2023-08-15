package sk.mirri.ootspoc.backend.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.ws.Holder;

import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.domibus.common.model.org.oasis_open.docs.ebxml_msg.ebms.v3_0.ns.core._200704.CollaborationInfo;
import eu.domibus.common.model.org.oasis_open.docs.ebxml_msg.ebms.v3_0.ns.core._200704.From;
import eu.domibus.common.model.org.oasis_open.docs.ebxml_msg.ebms.v3_0.ns.core._200704.MessageProperties;
import eu.domibus.common.model.org.oasis_open.docs.ebxml_msg.ebms.v3_0.ns.core._200704.Messaging;
import eu.domibus.common.model.org.oasis_open.docs.ebxml_msg.ebms.v3_0.ns.core._200704.PartInfo;
import eu.domibus.common.model.org.oasis_open.docs.ebxml_msg.ebms.v3_0.ns.core._200704.PartyInfo;
import eu.domibus.common.model.org.oasis_open.docs.ebxml_msg.ebms.v3_0.ns.core._200704.PayloadInfo;
import eu.domibus.common.model.org.oasis_open.docs.ebxml_msg.ebms.v3_0.ns.core._200704.To;
import eu.domibus.common.model.org.oasis_open.docs.ebxml_msg.ebms.v3_0.ns.core._200704.UserMessage;
import eu.domibus.plugin.webService.generated.BackendInterface;
import eu.domibus.plugin.webService.generated.BackendService11;
import eu.domibus.plugin.webService.generated.GetErrorsRequest;
import eu.domibus.plugin.webService.generated.GetMessageErrorsFault;
import eu.domibus.plugin.webService.generated.LargePayloadType;
import eu.domibus.plugin.webService.generated.RetrieveMessageFault;
import eu.domibus.plugin.webService.generated.RetrieveMessageRequest;
import eu.domibus.plugin.webService.generated.RetrieveMessageResponse;
import eu.domibus.plugin.webService.generated.SubmitMessageFault;
import eu.domibus.plugin.webService.generated.SubmitRequest;
import eu.domibus.plugin.webService.generated.SubmitResponse;
import sk.mirri.ootspoc.data.EvidenceMessage;
import sk.mirri.ootspoc.data.EvidenceRequestPayload;
import sk.mirri.ootspoc.mapdb.MessageIdDatabase;

public class BackendClientService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BackendClientService.class);

	private final BackendService11 backendService;

	public final BackendInterface port;

	private MessageIdDatabase db;

	public BackendClientService(final URL anUrl, final MessageIdDatabase aDb) throws MalformedURLException {
		backendService = new BackendService11(anUrl);
		port = backendService.getBACKENDPORT();
		db = aDb;
	}

	public List<String> getFilteredPendingMessages() {
		List<String> messages = port.listPendingMessages(null).getMessageID();
		db.cleanup(messages);
		return messages.stream().filter(messageId -> {
			if (db.shouldBeSkipped(messageId)) {
				LOGGER.info("Message {} will be skipped.", messageId);
				return false;
			}
			if (hasErrors(messageId)) {
				LOGGER.info("Message {} will be skipped because it contains errors.", messageId);
				return false;
			}
			return true;
		}).collect(Collectors.toList());
	}

	private boolean hasErrors(final String aMessageId) {
		GetErrorsRequest errorRequest = new GetErrorsRequest();
		errorRequest.setMessageID(aMessageId);
		try {
			if (port.getMessageErrors(errorRequest).getItem().size() > 0) {
				return true;
			}
		} catch (GetMessageErrorsFault e) {
			LOGGER.error("An exception occurred while requesting errors for message {}: {}", aMessageId, e);
		}
		return false;
	}

	public EvidenceMessage retrieveMessage(final String aMessageId) {
		RetrieveMessageRequest request = new RetrieveMessageRequest();
		request.setMessageID(aMessageId);
		Holder<RetrieveMessageResponse> response = new Holder<RetrieveMessageResponse>(new RetrieveMessageResponse());
		Holder<Messaging> messaging = new Holder<Messaging>(new Messaging());
		try {
			port.retrieveMessage(request, response, messaging);
		} catch (RetrieveMessageFault e) {
			LOGGER.error("An exception occurred while retrieving message {}: {}", aMessageId, e);
		}
		return new EvidenceMessage(response, messaging);
	}

	public void sendResponseFor(EvidenceRequestPayload aRequestPayload,
			List<Pair<PartInfo, LargePayloadType>> responsePayloads) {
		SubmitRequest request = new SubmitRequest();
		request.getPayload().addAll(responsePayloads.stream().map(Pair::getValue).collect(Collectors.toList()));

		Messaging responseMessaging = new Messaging();
		UserMessage userMessage = new UserMessage();
		PartyInfo partyInfo = new PartyInfo();

		From from = new From();
		from.setPartyId(aRequestPayload.getMessaging().getUserMessage().getPartyInfo().getTo().getPartyId());
		from.setRole(aRequestPayload.getMessaging().getUserMessage().getPartyInfo().getTo().getRole());
		partyInfo.setFrom(from);

		To to = new To();
		to.setPartyId(aRequestPayload.getMessaging().getUserMessage().getPartyInfo().getFrom().getPartyId());
		to.setRole(aRequestPayload.getMessaging().getUserMessage().getPartyInfo().getFrom().getRole());
		partyInfo.setTo(to);

		CollaborationInfo collaborationInfo = new CollaborationInfo();
		collaborationInfo
				.setService(aRequestPayload.getMessaging().getUserMessage().getCollaborationInfo().getService());
		collaborationInfo.setAction("ExecuteQueryResponse");
		collaborationInfo.setConversationId(
				aRequestPayload.getMessaging().getUserMessage().getCollaborationInfo().getConversationId());

		MessageProperties messageProperties = aRequestPayload.getMessaging().getUserMessage().getMessageProperties();

		PayloadInfo payloadInfo = new PayloadInfo();

		payloadInfo.getPartInfo().addAll(responsePayloads.stream().map(Pair::getKey).collect(Collectors.toList()));

		userMessage.setPartyInfo(partyInfo);
		userMessage.setCollaborationInfo(collaborationInfo);
		userMessage.setMessageProperties(messageProperties);
		userMessage.setPayloadInfo(payloadInfo);
		responseMessaging.setUserMessage(userMessage);

		try {
			SubmitResponse response = port.submitMessage(request, responseMessaging);
			LOGGER.info("Response has been sent, messageId: {}",
					response.getMessageID().stream().collect(Collectors.joining(", ")));

			db.addMessagesToSkip(
					// FIXME neviem preco id spravy ma na konci _1
					response.getMessageID().stream().map(message -> String.format("%s_1", message))
							.collect(Collectors.toList()));
		} catch (SubmitMessageFault e) {
			LOGGER.error("An exception occurred while sending evidence for request {}: {}", aRequestPayload, e);
		}
	}
}
