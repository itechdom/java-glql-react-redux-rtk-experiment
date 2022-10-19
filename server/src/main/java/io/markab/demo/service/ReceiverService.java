package io.markab.demo.service;
import java.util.concurrent.CountDownLatch;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(queues = "spring-boot")
public class ReceiverService {
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
    }
}
