package com.johanna.organizationservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "Organization service APIs",
				description = "Documentation for organization service REST APIs",
				version = "v1.0",
				contact = @Contact(
						name = "Johanna",
						email = "theyohancraft@gmail.com",
						url = "https://github.com/The-yohanna"
				)
		)
)
@SpringBootApplication
public class OrganizationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationServiceApplication.class, args);
	}

}
