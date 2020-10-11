package com.example.section_5;

import org.springframework.integration.core.MessageSelector;
import org.springframework.messaging.Message;

public class CustomFilter implements MessageSelector {
    @Override
    public boolean accept(Message<?> message) {
        Object payload = message.getPayload();
        return payload instanceof Integer;
    }
}
