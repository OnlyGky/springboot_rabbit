package com.example.demo.dlx;

import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class dlxSend {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    public void sendDlx(){
        rabbitTemplate.convertAndSend("sunspring_order_exchange", "sunspring.order",
                "abc", message -> {
                    message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                    message.getMessageProperties().setExpiration("10000");
                    return message;
                });
    }
}
