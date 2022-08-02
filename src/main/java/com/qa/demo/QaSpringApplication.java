package com.qa.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value="com.qa.beans")
@ComponentScan(value="com.qa.controllers")
@EntityScan(value="com.qa.entities")
public class QaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(QaSpringApplication.class, args);
		System.out.println("Hello World!");
	}

	
}
