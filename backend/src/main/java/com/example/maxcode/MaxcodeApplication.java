package com.example.maxcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MaxcodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaxcodeApplication.class, args);
	}

}
