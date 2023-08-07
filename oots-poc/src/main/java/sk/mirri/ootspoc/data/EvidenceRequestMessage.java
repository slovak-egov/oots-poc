package sk.mirri.ootspoc.data;

import java.util.List;
import java.util.stream.Collectors;

import javax.xml.ws.Holder;

import eu.domibus.common.model.org.oasis_open.docs.ebxml_msg.ebms.v3_0.ns.core._200704.Messaging;
import eu.domibus.plugin.webService.generated.RetrieveMessageResponse;

public class EvidenceRequestMessage {

	private final RetrieveMessageResponse response;
	private final Messaging messaging;

	public EvidenceRequestMessage(final Holder<RetrieveMessageResponse> aResponseHolder,
			final Holder<Messaging> aMessagingHolder) {
		response = aResponseHolder.value;
		messaging = aMessagingHolder.value;
	}

	public RetrieveMessageResponse getResponse() {
		return response;
	}

	public Messaging getMessaging() {
		return messaging;
	}

	public List<EvidenceRequestPayload> extractPayloads() {
		int size = response.getPayload().size();
		return response.getPayload().stream().map(item -> new EvidenceRequestPayload(item, size, messaging))
				.collect(Collectors.toList());
	}

	@Override
	public String toString() {
		return "{conversationId: " + messaging.getUserMessage().getCollaborationInfo().getConversationId() + ", from: "
				+ messaging.getUserMessage().getPartyInfo().getFrom().getPartyId().getValue() + ", to: "
				+ messaging.getUserMessage().getPartyInfo().getTo().getPartyId().getValue() + ", payloadsCount: "
				+ response.getPayload().size() + "}";
	}

}
