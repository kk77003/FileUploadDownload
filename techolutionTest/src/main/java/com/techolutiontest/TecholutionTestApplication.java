package com.techolutiontest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class TecholutionTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TecholutionTestApplication.class, args);
	}
}
