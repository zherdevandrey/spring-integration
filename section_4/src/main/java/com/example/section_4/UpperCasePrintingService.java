package com.example.section_4;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

public class UpperCasePrintingService {

    public Message<String> print(Message<String> message) {
        int messageNumber = (int) message.getHeaders().get("messageNumber");

        return MessageBuilder
                .withPayload(("Reply on message id = " + messageNumber).toUpperCase())
                .build();
    }

}
