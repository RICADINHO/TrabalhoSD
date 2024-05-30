package com.example.trabalhosd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TrabalhoSdApplication {

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
	// Para criar as tabelas, basta correr a aplicação
	public static void main(String[] args) {
		System.out.println("ola");
		SpringApplication.run(TrabalhoSdApplication.class, args);
	}

}
