package sk.mirri.ootspoc;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

	@Autowired
	private CamelContext camelContext;

	@RequestMapping("/retrieve/{messageId}")
	public String retrieveMessage(@PathVariable String messageId) {
		ProducerTemplate producerTemplate = camelContext.createProducerTemplate();
		producerTemplate.sendBody("direct:retrieveMessage", messageId);
		return "Message " + messageId + " will be processed.";
	}

	@RequestMapping("/retrieve/all")
	public String retrieveMessage() {
		ProducerTemplate producerTemplate = camelContext.createProducerTemplate();
		producerTemplate.sendBody("direct:listPendingMessages", null);
		return "All messages will be processed.";
	}
}