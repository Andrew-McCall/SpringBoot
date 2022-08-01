package com.qa.demo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanExample2 {
	
	@Size(min=2, max=12)
	@NotNull
	private String email;
	
	@Min(0)
	@Max(110)
	private int age;
	

	@Bean
	@Scope("prototype")
	public String greetingTwo() {
		return "Hello my friends";
	}
	
}
