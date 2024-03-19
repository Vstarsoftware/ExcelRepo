package com.excel.api.demoproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoprojectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoprojectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("this is testing");
	}
}
