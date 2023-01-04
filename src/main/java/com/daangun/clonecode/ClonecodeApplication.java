package com.daangun.clonecode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ClonecodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClonecodeApplication.class, args);
	}

}
