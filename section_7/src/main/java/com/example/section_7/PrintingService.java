package com.example.section_7;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

public class PrintingService {

    public void print(Message<?> message) {

        System.out.println("MESSAGE HEADER - " + message.getPayload());
        System.out.println("MESSAGE PAYLOAD - " + message.getHeaders());

    }


}
