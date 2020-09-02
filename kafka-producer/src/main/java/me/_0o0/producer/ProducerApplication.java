package me._0o0.producer;
//pzhang
import me._0o0.common.Message;
import me._0o0.producer.service.OutputMessageService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@EnableBinding(OutputMessageService.class)
@RestController
@SpringBootApplication
public class ProducerApplication {

	private OutputMessageService outputMessageService;

	public ProducerApplication(OutputMessageService outputMessageService) {
		this.outputMessageService = outputMessageService;
	}

	public static void main(String[] args) {
		new SpringApplicationBuilder(ProducerApplication.class).run(args);
	}

	@GetMapping("message")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void message(@RequestParam String content) {
		Message msg = Message.builder()
				.id(new Random().nextInt())
				.content(content)
				.build();
		outputMessageService.getOutput()
				.send(MessageBuilder.withPayload(msg)
						.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
						.build());
	}
}
