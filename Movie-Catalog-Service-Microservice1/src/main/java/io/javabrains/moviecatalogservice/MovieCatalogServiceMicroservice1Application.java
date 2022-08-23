package io.javabrains.moviecatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class MovieCatalogServiceMicroservice1Application {

	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogServiceMicroservice1Application.class, args);
	}

	// For Synchronous call.
	@Bean
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	// For Asynchronous call. WebClient is a reactive programming.
	@Bean
	WebClient.Builder getWebClientBuilder() {
		return WebClient.builder();
	}
}
