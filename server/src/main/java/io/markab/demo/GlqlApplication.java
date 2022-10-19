package io.markab.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.markab.demo.model.Book;

@SpringBootApplication
@RestController
public class GlqlApplication {

	@GetMapping("/")
	@CrossOrigin(origins = "http://localhost:3001")
	Book get() {
		Book b = new Book("7", "Book7", 1, "3");
		return b;
	}

	public static void main(String[] args) {
		SpringApplication.run(GlqlApplication.class, args);
	}

}
