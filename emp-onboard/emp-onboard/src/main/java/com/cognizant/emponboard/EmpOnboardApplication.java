package com.cognizant.emponboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.cognizant.emponboard.repo")
@EntityScan(basePackages = "com.cognizant.emponboard.model")
//@ComponentScan(basePackages="com.cognizant.emponboard")
@EnableDiscoveryClient
public class EmpOnboardApplication {

	public static void main(String[] args) {

		SpringApplication.run(EmpOnboardApplication.class, args);

	}

	
	
}
