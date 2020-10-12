package com.example.section_8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("integration-context.xml")
public class Section8Application {

    public static void main(String[] args) {
        SpringApplication.run(Section8Application.class, args);
    }

}
