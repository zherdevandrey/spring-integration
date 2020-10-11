package com.example.section_5;

import org.springframework.integration.splitter.AbstractMessageSplitter;
import org.springframework.messaging.Message;

import java.util.Arrays;
import java.util.List;

public class CustomSplitter extends AbstractMessageSplitter {

    @Override
    protected Object splitMessage(Message<?> message) {

        String payload = (String) message.getPayload();

        List<String> values = Arrays.asList(payload.split(" "));

        return values;
    }

}
