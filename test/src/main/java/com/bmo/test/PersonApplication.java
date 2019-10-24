package com.bmo.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import javax.swing.*;


@SpringBootApplication(scanBasePackages = {
		"com.bmo.test.rest","com.bmo.test.config"
})
public class PersonApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
		return builder.sources(PersonApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(PersonApplication.class, args);
	}

}
