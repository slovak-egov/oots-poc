package sk.mirri.ootspoc.data;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.activation.DataSource;

import eu.domibus.common.model.org.oasis_open.docs.ebxml_msg.ebms.v3_0.ns.core._200704.Messaging;
import eu.domibus.plugin.webService.generated.LargePayloadType;

public class EvidenceRequestPayload {
	private final LargePayloadType payload;
	private final int payloadsCount;
	private final Messaging messaging;

	public EvidenceRequestPayload(LargePayloadType payload, int payloadsCount, Messaging messaging) {
		super();
		this.payload = payload;
		this.payloadsCount = payloadsCount;
		this.messaging = messaging;
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
		return "{conversationId: " + messaging.getUserMessage().getCollaborationInfo().getConversationId()
				+ ", payload: " + getPayloadContent() + "}";
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

}
