package com.example.section_5;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

public class StringPrintingService {

    public Message<String> print(Message<String> message) {

        String payload = message.getPayload();

        System.out.println("String message " + payload);

        return MessageBuilder
                .withPayload("String message " + payload)
                .build();
    }

}
