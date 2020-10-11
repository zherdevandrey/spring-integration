package com.example.section_5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.router.AbstractMessageRouter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import java.util.ArrayList;
import java.util.Collection;

public class CustomRouter extends AbstractMessageRouter {

    @Autowired
    @Qualifier("intChannel")
    MessageChannel intChannel;

    @Autowired
    @Qualifier("stringChannel")
    MessageChannel stringChannel;

    @Override
    protected Collection<MessageChannel> determineTargetChannels(Message<?> message) {
        Collection<MessageChannel> channels = new ArrayList<>();

        Object payload = message.getPayload();

        if (payload instanceof String){
            channels.add(stringChannel);
        }else {
            channels.add(intChannel);
        }

        return channels;
    }
}
