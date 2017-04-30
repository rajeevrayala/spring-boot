package com.rayala;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloRestWithCassandraApplication {

	@Autowired
	private CustomerRepository repository;

	public void run(String... args) throws Exception {
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloRestWithCassandraApplication.class, args);
	}
}
