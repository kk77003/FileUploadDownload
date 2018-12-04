package com.techolutiontest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({ "com.techolutiontest" })
public class TecholutionTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TecholutionTestApplication.class, args);
	}
}
