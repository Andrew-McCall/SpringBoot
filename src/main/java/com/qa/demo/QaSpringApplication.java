package com.qa.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value="com.qa.beans")
public class QaSpringApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(QaSpringApplication.class, args);

		new Profile(0, null);
		
	    Object byName = context.getBean("greeting");
	    //String byType = context.getBean(String.class);
	    String byBoth = context.getBean("greetingTwo", String.class);
	    
	    System.out.println(byName);
	    //System.out.println(byType);
	    System.out.println(byBoth);
	}

	
}
