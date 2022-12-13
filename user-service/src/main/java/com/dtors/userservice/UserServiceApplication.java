package com.dtors.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RequestMapping("/user")
public class UserServiceApplication {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/check")
	public String getCatalogue(){

		return "";
	}
	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
