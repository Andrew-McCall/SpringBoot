package com.qa.runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(value = "com.qa.beans")
@ComponentScan(value = "com.qa.controllers")
@EntityScan(value = "com.qa.entities")
@EnableJpaRepositories("com.qa.repos")
public class QaSpringApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(QaSpringApplication.class, args);
		System.out.println("Hello World!");
		System.out.println(context.getBean("greetingTwo"));
	}

}
