package com.jackxue.producer;

import com.jackxue.message.BroadcastMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BroadcastProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void syncSend(Long id){
        BroadcastMessage message = new BroadcastMessage();
        message.setId(id);
        rabbitTemplate.convertAndSend(BroadcastMessage.EXCHANGE, null, message);
    }
}
