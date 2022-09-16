package com.musalaSoft.musalaSoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MusalaSoftApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusalaSoftApplication.class, args);
	}

}
