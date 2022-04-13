package com.deloitte.asses.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;

@EntityScan(basePackages = {"com.deloitte.asses.todo"})
@SpringBootApplication(scanBasePackages = "com.deloitte.asses.todo")
public class TodoApplication {
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(TodoApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

}
