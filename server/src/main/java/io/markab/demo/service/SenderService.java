package io.markab.demo.service;

import java.util.concurrent.TimeUnit;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(queues = "spring-boot")
public class SenderService implements Runnable {
    ReceiverService receiverService;

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;

    public void sendMessage() {

    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        template.convertAndSend("spring-boot-exchange", "foo.bar.#", "Hello from RabbitMQ!");
        System.out.println(Thread.currentThread().getName());
        System.out.println("Sending message...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
