package com.dtors.userservice;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RequestMapping("/user")
public class UserServiceApplication {

	public static final String CATALOGUE_SERVICE_URL = "http://localhost:8081";

	@Autowired
	private RestTemplate restTemplate;



	@GetMapping("/displayCatalogue")
	@CircuitBreaker(name = "", fallbackMethod = "falBackMethod")
	public String getCatalogue(){
		String catalogueResponse = restTemplate.getForObject(CATALOGUE_SERVICE_URL+"/catalogue", String.class);

		return catalogueResponse;
	}

	public String falBackMethod()
	{
		return "";
	}
	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}


	@Bean
	public RestTemplate template(){
		return new RestTemplate();
	}
}
