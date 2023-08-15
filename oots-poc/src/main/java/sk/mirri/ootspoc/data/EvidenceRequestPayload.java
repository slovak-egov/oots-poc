package sk.mirri.ootspoc.data;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.UUID;

import javax.activation.DataSource;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.w3c.dom.Element;

import eu.domibus.common.model.org.oasis_open.docs.ebxml_msg.ebms.v3_0.ns.core._200704.Messaging;
import eu.domibus.plugin.webService.generated.LargePayloadType;
import sk.mirri.ootspoc.wsplugin.regrep4.AnyValueType;
import sk.mirri.ootspoc.wsplugin.regrep4.QueryRequest;

public class EvidenceRequestPayload {
	private final LargePayloadType payload;
	private final int payloadsCount;
	private final Messaging messaging;
	private final UUID conversationId;
	private final QueryRequest queryRequest;
	private final String evidenceClassification;

	public EvidenceRequestPayload(LargePayloadType aPayload, int aPayloadsCount, Messaging aMessaging,
			UUID aConversationId) {
		super();
		payload = aPayload;
		payloadsCount = aPayloadsCount;
		messaging = aMessaging;
		conversationId = aConversationId;
		queryRequest = extractQueryRequest();
		evidenceClassification = extractEvidenceClassification();
	}

	private String getPayloadContent() {
		try {
			DataSource dataSource = payload.getValue().getDataSource();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int bytesRead;
			InputStream inputStream = dataSource.getInputStream();
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}
			String content = outputStream.toString("UTF-8");
			return content;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String toString() {
		// TODO zistit preco chyba conversationId
		return "{conversationId: " + conversationId.toString() + ", payload: " + getPayloadContent()
				+ ", evidence classification: " + evidenceClassification + "}";

	}

	public LargePayloadType getPayload() {
		return payload;
	}

	public int getPayloadsCount() {
		return payloadsCount;
	}

	public Messaging getMessaging() {
		return messaging;
	}

	public QueryRequest extractQueryRequest() {
		try {
			JAXBContext context = JAXBContext.newInstance(QueryRequest.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();

			StringReader reader = new StringReader(getPayloadContent());
			QueryRequest queryRequest;

			queryRequest = (QueryRequest) unmarshaller.unmarshal(reader);
			return queryRequest;
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public String extractEvidenceClassification() {
		// TODO prerobit cistejsie
		Element element = ((Element) ((AnyValueType) queryRequest.getQuery().getSlot().stream()
				.filter(type -> type.getName().equals("EvidenceRequest")).findAny().get().getSlotValue()).getAny());
		return element.getElementsByTagName("sdg:EvidenceTypeClassification").item(0).getTextContent();
	}

	public String getEvidenceClassification() {
		return evidenceClassification;
	}

}
