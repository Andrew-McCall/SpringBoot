package com.qa.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

@Configuration
@Profile("dev")
public class BeanExample2 {

	@Bean
	@Primary
	@Scope("prototype")
	public String greetingTwo() {
		return "Hello my friends";
	}

}
