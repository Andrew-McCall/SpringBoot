package com.qa.beans;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class BeanExample {

	@Bean
	public String greeting() {
		return "Hello World";
	}

	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}

	@Profile("!dev")
	@Bean
	public String greetingTwo() {
		return "Hello twoooo";
	}

}
