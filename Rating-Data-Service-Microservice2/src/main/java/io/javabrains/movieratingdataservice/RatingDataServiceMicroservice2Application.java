package io.javabrains.movieratingdataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RatingDataServiceMicroservice2Application {

	public static void main(String[] args) {
		SpringApplication.run(RatingDataServiceMicroservice2Application.class, args);
	}

}
