package com.example.section_10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("integration-context.xml")
public class Section10Application implements ApplicationRunner {

    @Autowired
    private JdbcGateway jdbcGateway;

    public static void main(String[] args) {
        SpringApplication.run(Section10Application.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Person person = Person.builder()
                .firstName("person")
                .lastName("1234567")
                .id(100)
                .build();

        jdbcGateway.save(person);
    }
}
