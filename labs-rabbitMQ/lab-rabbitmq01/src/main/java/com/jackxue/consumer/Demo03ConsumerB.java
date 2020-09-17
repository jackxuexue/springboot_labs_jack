package com.jackxue.consumer;

import com.jackxue.message.Demo03Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RabbitListener(queues = Demo03Message.QUEUE_B)
public class Demo03ConsumerB {

    @RabbitHandler
    public void onMessage(Demo03Message message){
        log.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
    }
}
