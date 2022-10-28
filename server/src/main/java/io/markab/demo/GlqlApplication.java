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

	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

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

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		ListNode resultNode = new ListNode();
		// check l1.next, l2.next whichever contains next move to them
		// if last index, then add a new node
		// else add carry to current value
		while (l1 != null && l2 != null) {
			int val1 = l1.val;
			int val2 = l2.val;
			int sum = val1 + val2 + carry;
			carry = sum % 9;
			if (carry != 0) {
				resultNode.val = sum - 10;
			} else {
				resultNode.val = sum;
			}
			l1 = l1.next;
			l2 = l2.next;
			resultNode.next = new ListNode();
		}
		return resultNode;
	}

	public static void main(String[] args) {
		ListNode l3 = new ListNode(5);
		ListNode l2 = new ListNode(4, l3);
		ListNode l1 = new ListNode(3, l2);

		ListNode l6 = new ListNode(7);
		ListNode l5 = new ListNode(8, l6);
		ListNode l4 = new ListNode(9, l5);

		ListNode result = addTwoNumbers(l1, l4);

		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}

		// System.out.println(result.toString());

		// SpringApplication.run(GlqlApplication.class, args);
	}

}
