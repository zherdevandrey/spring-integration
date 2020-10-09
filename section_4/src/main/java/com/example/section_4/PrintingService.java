package com.example.section_4;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

public class PrintingService {

    public Message<String> print(Message<String> message) {
        int messageNumber = (int) message.getHeaders().get("messageNumber");

        System.out.println("Normal reply on message id = " + messageNumber);

        return MessageBuilder
                .withPayload("Normal reply on message id = " + messageNumber)
                .build();
    }

}
