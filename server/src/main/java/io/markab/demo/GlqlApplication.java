package io.markab.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import io.markab.demo.model.Book;
import io.markab.demo.service.ReceiverService;
import io.markab.demo.service.SenderService;

@SpringBootApplication
@RestController
public class GlqlApplication {

	@Autowired
	SenderService senderService;

	@Autowired
	ReceiverService receiverService;

	@GetMapping("/")
	@CrossOrigin(origins = "http://localhost:3001")
	Book get() {
		Book b = new Book("7", "Book7", 1, "3");
		Thread t = new Thread(senderService);
		t.start();
		senderService.sendMessage(b);
		return b;
	}

	@GetMapping("/remove")
	@CrossOrigin(origins = "http://localhost:3001")
	Book removeBook() {
		Book b = new Book("7", "Book7", 1, "3");
		Thread t = new Thread(receiverService);
		t.start();
		return b;
	}

	public static void readAFile() {
		FileInputStream inputStream = null;
		String path = "/Users/osamaalghanmi/java-glql-react-redux-rtk-experiment/server/lines.txt";
		Scanner sc = null;
		try {
			inputStream = new FileInputStream(path);
			sc = new Scanner(inputStream, "UTF-8");
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				System.out.println(line);
			}
			// note that Scanner suppresses exceptions
			if (sc.ioException() != null) {
				throw sc.ioException();
			}
		} catch (IOException e) {
			e.printStackTrace();

			// inputStream.close();
		} finally {
			if (inputStream != null) {
				// inputStream.close();
			}
			if (sc != null) {
				sc.close();
			}
		}
		if (inputStream != null) {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(GlqlApplication.class, args);
	}

}
