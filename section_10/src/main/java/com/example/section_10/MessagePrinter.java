package com.example.section_10;

import org.springframework.messaging.Message;

public class MessagePrinter {

	public void print(Message<?> message){
		System.out.println("PAYLOAD - " + message.getPayload());
		System.out.println("HEADER - " + message.getHeaders());
	}
}
