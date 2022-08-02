package com.qa.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanExample2 {
	
	@Bean
	@Scope("prototype")
	public String greetingTwo() {
		return "Hello my friends";
	}
	
}
