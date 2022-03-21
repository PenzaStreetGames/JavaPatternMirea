package com.penzastreetstudios.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ProgrammerConfiguration.class);

        if (args.length == 0) {
            Programmer junior = (Programmer) context.getBean("Junior");
            Programmer middle = (Programmer) context.getBean("Middle");
            Programmer senior = (Senior) context.getBean("Senior");

            for (Programmer programmer : Arrays.asList(junior, middle, senior)) {
                System.out.println(programmer.doCoding());
            }
        }
        else {
            Programmer programmer = (Programmer) context.getBean(args[0]);
            System.out.println(programmer.doCoding());
        }
    }
}
