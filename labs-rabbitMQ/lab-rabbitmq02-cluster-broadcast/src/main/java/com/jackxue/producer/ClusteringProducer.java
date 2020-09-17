package com.jackxue.producer;

import com.jackxue.message.ClustingMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ClusteringProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void syncSend(Integer id){
        ClustingMessage clustingMessage = new ClustingMessage();
        clustingMessage.setId(id);
        rabbitTemplate.convertAndSend(ClustingMessage.EXCHANGE, null, clustingMessage);
    }
}
