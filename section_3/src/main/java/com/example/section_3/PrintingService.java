package com.example.section_3;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

public class PrintingService {

    public Message<String> print(Message<String> message) {
        System.out.println("current - " + message.getPayload());

        return MessageBuilder
                .withPayload(message.getPayload().toUpperCase())
                .build();
    }

}
