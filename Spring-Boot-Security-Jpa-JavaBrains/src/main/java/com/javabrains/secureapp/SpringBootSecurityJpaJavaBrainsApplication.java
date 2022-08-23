package com.javabrains.secureapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.javabrains.secureapp.repository.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class SpringBootSecurityJpaJavaBrainsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityJpaJavaBrainsApplication.class, args);
	}

}
