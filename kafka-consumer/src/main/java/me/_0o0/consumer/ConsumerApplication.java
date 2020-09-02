package me._0o0.consumer;

import lombok.extern.slf4j.Slf4j;
import me._0o0.common.Message;
import me._0o0.consumer.service.InputMessageService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@Slf4j
@EnableBinding(InputMessageService.class)
@SpringBootApplication
public class ConsumerApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ConsumerApplication.class).run(args);
	}

	@StreamListener("message-in")
	public void handleMessage(Message msg) {
		log.info("Receive message: [{}]", msg);
	}
}
