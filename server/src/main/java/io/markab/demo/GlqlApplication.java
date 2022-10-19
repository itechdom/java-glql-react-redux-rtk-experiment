package io.markab.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import io.markab.demo.model.Book;
import io.markab.demo.service.SenderService;

@SpringBootApplication
@RestController
public class GlqlApplication {

	@Autowired
	SenderService senderService;

	@GetMapping("/")
	@CrossOrigin(origins = "http://localhost:3001")
	Book get() {
		Book b = new Book("7", "Book7", 1, "3");
		// Thread t = new Thread(senderService);
		// t.start();
		senderService.run();
		return b;
	}

	public static void main(String[] args) {
		SpringApplication.run(GlqlApplication.class, args);
	}

}
