package com.qa.dfespringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class DfeSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(DfeSpringBootApplication.class, args);
	}

}
