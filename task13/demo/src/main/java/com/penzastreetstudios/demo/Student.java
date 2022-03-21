package com.penzastreetstudios.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Student {
    @Value("${program.student.name}")
    String name;
    @Value("${program.student.surname}")
    String surname;
    @Value("${program.student.group}")
    String group;

    @PostConstruct
    public void printStudent() {
        System.out.println(name + " " + surname + " " + group);
    }
}
