package io.markab.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.markab.demo.model.Author;
import io.markab.demo.model.Book;

@Service
@RabbitListener(queues = "spring-boot")
public class SenderService {
    // ReceiverService receiverService;

    // @Autowired
    // private RabbitTemplate template;

    // @Autowired
    // private Queue queue;

    // public void sendMessage(Book book) {
    //     // TODO Auto-generated method stub
    //     template.convertAndSend("spring-boot-exchange", "foo.bar.#", book);

    // }

    // @Override
    // public void run() {
    //     Book.booksChangeable.add(new Book("hello", "BOOKStat", 0, "10"));
    //     Book.authorChangeable.add(new Author("author", "author-a", "author-a"));
    //     List<Book> mappedBooks = Book.booksChangeable.stream().map((book) -> book)
    //             .collect(Collectors.toList());
    //     System.out.println("Sending message...");
    //     try {
    //         Thread.sleep(5000);
    //         // Book.booksChangeable.remove(0);
    //         // Book.booksChangeable.add(0, new Book("added", "added", 100, "added"));
    //         System.out.println("----------------------");
    //         mappedBooks.forEach((author) -> System.out.println(author));
    //         System.out.println("----------------------");
    //     } catch (InterruptedException e) {
    //         // TODO Auto-generated catch block
    //         e.printStackTrace();
    //     }
    // }

}
