package com.example.section_4;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@SpringBootApplication
@ImportResource("integration-context.xml")
public class Section4Application implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(Section4Application.class, args);
    }

    @Autowired
    private PrinterGateWay printerGateWay;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<Future<Message<String>>> futures = new ArrayList<>();

        for (int i = 0 ; i < 10 ; i ++){
            Message<String> message = MessageBuilder
                    .withPayload(" message payload " + i)
                    .setHeader("messageNumber", i)
                    .setPriority(i)
                    .build();

            Future<Message<String>> result = printerGateWay.print(message);
            System.out.println("submitted message with id = " + i);
            futures.add(result);
        }

        futures.forEach(val -> System.out.println(getPayload(val)));
    }

    @SneakyThrows
    private String getPayload(Future<Message<String>> future) {
        return future.get().getPayload();
    }
}
