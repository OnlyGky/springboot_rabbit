package com.example.demo.dlx;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
//死信生产者
@Component
@RabbitListener(queues="sunspring.dlx.queue")
public class dlxRecever {
    @RabbitHandler
    public void dlxListener(String message) throws IOException {
        System.out.println("re:  "+message);
    }
}
