package com.jakxue.producer;

import com.jakxue.message.OrderlyMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderlyProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void syncSend(int id){
        OrderlyMessage message = new OrderlyMessage();
        message.setId(id);
        System.out.println(id + "================key:" + this.getKey(id));
        rabbitTemplate.convertAndSend(OrderlyMessage.ORDER_EXCHANG, this.getKey(id), message);
    }

    private String getKey(int id){
        return String.valueOf(id % OrderlyMessage.QUEUE_COUNT);
    }


}
