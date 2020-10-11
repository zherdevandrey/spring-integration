package com.example.section_5;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

public class IntPrintingService {

    public Message<String> print(Message<Integer> message) {

        Integer payload = message.getPayload();

        System.out.println("Int message " + payload);

        return MessageBuilder
                .withPayload("Int message " + payload)
                .build();
    }

}
