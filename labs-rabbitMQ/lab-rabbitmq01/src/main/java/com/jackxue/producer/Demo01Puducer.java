package com.jackxue.producer;

import com.jackxue.message.Demo01Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import javax.annotation.Resource;

@Component
public class Demo01Puducer {

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void syncSend(Integer id){
        Demo01Message demo01Message = new Demo01Message();
        demo01Message.setId(id);
        rabbitTemplate.convertAndSend(Demo01Message.EXCHANGE, Demo01Message.ROUTING_KEY, demo01Message);
    }

    public void syncSendDefault(Integer id){
        Demo01Message message = new Demo01Message();
        message.setId(id);
        rabbitTemplate.convertAndSend(Demo01Message.QUEUE, message);
    }

    @Async
    public ListenableFuture<Void> asyncSend(Integer id){
        try{
            this.syncSend(id);
            return AsyncResult.forValue(null);
        }catch (Throwable ex){
            return AsyncResult.forExecutionException(ex);
        }
    }
}
