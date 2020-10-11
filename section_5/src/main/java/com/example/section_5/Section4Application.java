package com.example.section_5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
@ImportResource("integration-context.xml")
public class Section4Application implements ApplicationRunner {

    @Autowired
    private PrinterGateWay printerGateWay;

    public static void main(String[] args) {
        SpringApplication.run(Section4Application.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Message<String> stringMessage = MessageBuilder
                .withPayload("String value")
                .setHeader("header", "String header")
                .build();

        Message<Integer> intMessage = MessageBuilder
                .withPayload(100)
                .setHeader("header", "Int header")
                .build();

        printerGateWay.print(stringMessage);
        printerGateWay.print(intMessage);

    }
}
