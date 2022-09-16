package io.javabrains.moviecatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class MovieCatalogServiceMicroservice1Application {

	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogServiceMicroservice1Application.class, args);
	}

	// For Synchronous call.
	@LoadBalanced
	@Bean
	RestTemplate getRestTemplate() {
		
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		clientHttpRequestFactory.setConnectTimeout(3000);
		return new RestTemplate(clientHttpRequestFactory);
		//return new RestTemplate();
	}

	// For Asynchronous call. WebClient is a reactive programming.
	@Bean
	WebClient.Builder getWebClientBuilder() {
		return WebClient.builder();
	}
}
