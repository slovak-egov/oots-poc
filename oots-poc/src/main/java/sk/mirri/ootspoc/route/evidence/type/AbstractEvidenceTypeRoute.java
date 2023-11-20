package sk.mirri.ootspoc.route.evidence.type;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.activation.DataHandler;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;

import com.sun.istack.ByteArrayDataSource;

import eu.domibus.common.model.org.oasis_open.docs.ebxml_msg.ebms.v3_0.ns.core._200704.PartInfo;
import eu.domibus.common.model.org.oasis_open.docs.ebxml_msg.ebms.v3_0.ns.core._200704.PartProperties;
import eu.domibus.common.model.org.oasis_open.docs.ebxml_msg.ebms.v3_0.ns.core._200704.Property;
import eu.domibus.plugin.webService.generated.LargePayloadType;
import sk.mirri.ootspoc.backend.client.BackendClientService;
import sk.mirri.ootspoc.data.EvidenceRequestPayload;
import sk.mirri.ootspoc.wsplugin.regrep4.QueryRequest;
import sk.mirri.ootspoc.wsplugin.regrep4.QueryResponse;

public abstract class AbstractEvidenceTypeRoute extends RouteBuilder {

	@Autowired
	private BackendClientService client;

	protected void sendEvidenceResponse(final Exchange anExchange) {
		EvidenceRequestPayload payload = anExchange.getIn().getBody(EvidenceRequestPayload.class);
		Pair<PartInfo, LargePayloadType> thePdfPayload = preparePayload("src/main/resources/evidence/evidence.pdf",
				"application/pdf", "cid:evidencepdf@oots.eu");
		Pair<PartInfo, LargePayloadType> theXmlPayload = preparePayload("src/main/resources/evidence/response.xml",
				"application/x-ebrs+xml", "cid:regrep@oots.eu");

		final List<Pair<PartInfo, LargePayloadType>> responsePayloads = new ArrayList<>();
		responsePayloads.add(theXmlPayload);
		responsePayloads.add(thePdfPayload);

		client.sendResponseFor(payload, responsePayloads);
	}

	protected void sendEmptyEvidenceResponse(final Exchange anExchange) {
		EvidenceRequestPayload payload = anExchange.getIn().getBody(EvidenceRequestPayload.class);
		Pair<PartInfo, LargePayloadType> theXmlPayload = preparePayload(
				"src\\main\\resources\\evidence\\responseEmpty.xml", "application/x-ebrs+xml", "cid:regrep@oots.eu");

		// TODO extract query request and build query response
		QueryResponse response = prepareEmptyResponse(payload.extractQueryRequest());

		final List<Pair<PartInfo, LargePayloadType>> responsePayloads = new ArrayList<>();
		responsePayloads.add(theXmlPayload);

		client.sendResponseFor(payload, responsePayloads);
	}

	protected QueryResponse prepareEmptyResponse(QueryRequest aQueryRequest) {
		QueryResponse response = new QueryResponse();
		response.setTotalResultCount(BigInteger.ZERO);
		return response;
	}

	protected Pair<PartInfo, LargePayloadType> preparePayload(String filePath, String contentType, String aPayloadId) {
		LargePayloadType thePayload = new LargePayloadType();
		thePayload.setContentType(contentType);

		File file = new File(filePath);

		PartInfo partInfo = new PartInfo();
		partInfo.setHref(aPayloadId);
		Property mimeTypeProperty = new Property();
		mimeTypeProperty.setName("MimeType");
		mimeTypeProperty.setValue(contentType);
		Property payloadNameProperty = new Property();
		payloadNameProperty.setName("PayloadName");
		payloadNameProperty.setValue(file.getName());
		PartProperties partProperties1 = new PartProperties();
		partProperties1.getProperty().addAll(Arrays.asList(mimeTypeProperty, payloadNameProperty));
		partInfo.setPartProperties(partProperties1);

		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			byte[] pdfBytes = new byte[(int) file.length()];
			fileInputStream.read(pdfBytes);
			fileInputStream.close();
			final ByteArrayDataSource barrds = new ByteArrayDataSource(pdfBytes, "application/octet-stream");
			final DataHandler data = new DataHandler(barrds);
			thePayload.setValue(data);
			thePayload.setPayloadId(aPayloadId);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Pair.of(partInfo, thePayload);
	}

}