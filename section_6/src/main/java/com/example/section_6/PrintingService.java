package com.example.section_6;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.PostConstruct;

public class PrintingService {

    public Message<String> print(Message<String> message) {

        System.out.println("MESSAGE HEADER - " + message.getPayload());
        System.out.println("MESSAGE PAYLOAD - " + message.getHeaders());

        return MessageBuilder
                .withPayload("Int message " + message.getPayload())
                .build();
    }


}
