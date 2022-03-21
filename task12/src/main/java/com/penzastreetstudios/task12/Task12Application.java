package com.penzastreetstudios.task12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Task12Application {

	static String pathSourceFile;
	static String pathHashFile;

	public static void main(String[] args) {
		pathSourceFile = args[0];
		pathHashFile = args[1];
		SpringApplication.run(Task12Application.class, args);
	}

}
