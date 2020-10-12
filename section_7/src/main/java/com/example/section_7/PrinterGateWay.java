package com.example.section_7;

import org.springframework.messaging.Message;

import java.util.concurrent.Future;

public interface PrinterGateWay {

    Future<Message<String>> print(Message<?> message);

}
