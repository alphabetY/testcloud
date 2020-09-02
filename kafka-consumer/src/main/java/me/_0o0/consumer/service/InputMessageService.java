package me._0o0.consumer.service;


import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface InputMessageService {

	@Input("message-in")
	MessageChannel input();
}
