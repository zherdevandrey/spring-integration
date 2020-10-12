package com.example.section_10;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

    private int id;
    private String firstName;
    private String lastName;

}