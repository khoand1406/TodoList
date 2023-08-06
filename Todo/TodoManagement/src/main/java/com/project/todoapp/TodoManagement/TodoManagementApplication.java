package com.project.todoapp.TodoManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class TodoManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoManagementApplication.class, args);
	}

}
