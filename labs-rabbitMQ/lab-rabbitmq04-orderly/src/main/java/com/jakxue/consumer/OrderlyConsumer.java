package com.jakxue.consumer;

import com.jakxue.message.OrderlyMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RabbitListener(queues = OrderlyMessage.QUEUE_0)
@RabbitListener(queues = OrderlyMessage.QUEUE_1)
@RabbitListener(queues = OrderlyMessage.QUEUE_2)
@RabbitListener(queues = OrderlyMessage.QUEUE_3)
public class OrderlyConsumer {

//    @RabbitHandler(isDefault = true)
//    public void onMessage(Message<OrderlyMessage> message){
//        log.info("线程编号[{}] 队列[{}] 消息体编号[{}]", Thread.currentThread().getId(), getQueueName(message), message.getPayload().getId());
//    }

    @RabbitHandler
    public void onMessage(OrderlyMessage message){
        log.info("线程编号[{}] 编号[{}]", Thread.currentThread().getId(), message.getId());
    }

    private String getQueueName(Message<OrderlyMessage> message){
        return message.getHeaders().get("amqp_consumerQueue", String.class);
    }
}
