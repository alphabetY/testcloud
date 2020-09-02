package me._0o0.producer.service;


import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface OutputMessageService {

	@Output("message-out")
	MessageChannel getOutput();
}
