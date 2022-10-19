package io.markab.demo.service;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import io.markab.demo.model.Book;

@Service
@RabbitListener(queues = "spring-boot")
public class ReceiverService {
    public void receiveMessage(Book book) {
        System.out.println("Received <" + book.toString() + ">");
    }
}
