package io.markab.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GlqlApplication {
	@GetMapping("/")
	String all() {
		return "hello";
	}
	public static void main(String[] args) {
		SpringApplication.run(GlqlApplication.class, args);
	}

}

