package com.johanna.employeeservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@OpenAPIDefinition(
		info = @Info(
				title = "Employee service APIs",
				description = "Documentation for employee service REST APIs",
				version = "v1.0",
				contact = @Contact(
						name = "Johanna",
						email = "theyohancraft@gmail.com",
						url = "https://github.com/The-yohanna"
				)
		)
)

@SpringBootApplication
@EnableFeignClients
public class EmployeeServiceApplication {

	@Bean
	public WebClient webClient() {
		return WebClient.builder().build();
	}

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
