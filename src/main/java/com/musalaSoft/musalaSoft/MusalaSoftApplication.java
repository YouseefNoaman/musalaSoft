package com.musalaSoft.musalaSoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan("com.musalaSoft.musalaSoft.repository")
@EntityScan("com.musalaSoft.musalaSoft.entity")
public class MusalaSoftApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusalaSoftApplication.class, args);
	}

}
