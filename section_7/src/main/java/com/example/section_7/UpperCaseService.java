package com.example.section_7;

import org.springframework.messaging.Message;

public class UpperCaseService {

    public void upperCase(Message<?> message){

        System.out.println("MESSAGE HEADER - " + message.getPayload().toString().toUpperCase());
        System.out.println("MESSAGE PAYLOAD - " + message.getHeaders().toString().toUpperCase());
    }

}
