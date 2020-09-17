package com.jackxue.producer;

import com.jackxue.message.DemoMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConcurrentProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void syncSend(Long id){
        DemoMessage demoMessage = new DemoMessage();
        demoMessage.setId(id);
        rabbitTemplate.convertAndSend(DemoMessage.EXCHANGE, DemoMessage.ROUTE_KEY, demoMessage);
    }
}
