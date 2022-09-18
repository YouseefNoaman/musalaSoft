package com.musalaSoft.musalaSoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@ComponentScan("com.musalaSoft.musalaSoft")
@OpenAPIDefinition(info = @Info(title = "musalasoft drone API", version = "0.0", description = "musalasoft task"))
public class MusalaSoftApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusalaSoftApplication.class, args);
	}

}
