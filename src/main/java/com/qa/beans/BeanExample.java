package com.qa.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanExample {

	@Bean
	public String greeting() {
		return "Hello World";
	}
	
}
