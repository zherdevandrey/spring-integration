package com.example.section_10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("integration-context.xml")
public class Section10Application {

    public static void main(String[] args) {
        SpringApplication.run(Section10Application.class, args);
    }

}
