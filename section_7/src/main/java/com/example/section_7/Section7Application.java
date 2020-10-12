package com.example.section_7;

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
public class Section7Application implements ApplicationRunner {

    @Autowired
    private EnhancedPrinterGateway printerGateWay;


    public static void main(String[] args) {
        SpringApplication.run(Section7Application.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Person person = Person.builder()
                .name("person")
                .age(100)
                .build();


        printerGateWay.print(person);
        printerGateWay.upper(person);
    }
}
