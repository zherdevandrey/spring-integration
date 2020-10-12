package com.example.section_6;

import org.springframework.messaging.Message;

public class CustomTransformer {

    public String transform(Message message){
        System.out.println("MESSAGE IS TRANSFORMED");
        return message.getPayload().toString().toUpperCase();
    }

}
