package com.example.springintegration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
@ImportResource("integration-context.xml")
public class SpringIntegrationApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringIntegrationApplication.class, args);
    }

    @Autowired
    @Qualifier("inputChannel")
    private DirectChannel input;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Message<String> inputMessage = MessageBuilder
                .withPayload("payload")
                .setHeader("header", "header")
                .build();

        Message returnMessage = new MessagingTemplate().sendAndReceive(input, inputMessage);

        System.out.println(returnMessage.getPayload());
    }
}
