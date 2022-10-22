package io.markab.demo.service;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import io.markab.demo.model.Book;

@Service
@RabbitListener(queues = "spring-boot")
public class ReceiverService extends ParentService implements Runnable{
    public void receiveMessage(Book book) {
        System.out.println("Received <" + book.toString() + ">");
    }
    public void fail(){
        
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        Book.booksChangeable.remove(0);
        System.out.println(Thread.currentThread().getName());
        System.out.println(Book.booksChangeable.toString() + "----" + Thread.currentThread().getName());
    }
}
