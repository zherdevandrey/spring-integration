package com.example.springintegration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
@ImportResource("integration-context.xml")
public class SpringIntegrationApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringIntegrationApplication.class, args);
    }

    @Autowired
    private PrintingService printingService;

    @Autowired
    @Qualifier("inputChannel")
    private DirectChannel input;

    @Autowired
    @Qualifier("outputChannel")
    private DirectChannel output;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        output.subscribe(message -> System.out.println(message.getPayload()));

        Message<String> message = MessageBuilder
                .withPayload("payload")
                .setHeader("header", "header")
                .build();
        input.send(message);


    }
}
