package com.herokuapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories
@EnableTransactionManagement
public class ThTShoesBackEndApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ThTShoesBackEndApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}
	
	
}
