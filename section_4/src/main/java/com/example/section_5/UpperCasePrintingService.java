package com.example.section_5;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

public class UpperCasePrintingService {

    public Message<String> print(Message<String> message) {
        int messageNumber = (int) message.getHeaders().get("messageNumber");

        System.out.println(("Upper reply on message id = " + messageNumber).toUpperCase());

        return MessageBuilder
                .withPayload(("Upper reply on message id = " + messageNumber).toUpperCase())
                .build();
    }

}
