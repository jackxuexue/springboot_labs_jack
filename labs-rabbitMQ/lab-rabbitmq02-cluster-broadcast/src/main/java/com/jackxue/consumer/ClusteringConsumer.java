package com.jackxue.consumer;

import com.jackxue.message.ClustingMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RabbitListener(
        bindings = @QueueBinding(
            value = @Queue(
                    name = ClustingMessage.QUEUE + "-" + "GROUP-01"
            ),
            exchange = @Exchange(
                    name = ClustingMessage.EXCHANGE,
                    type = ExchangeTypes.TOPIC,
                    declare = "false"
            ),
            key = "#"
        )
)
public class ClusteringConsumer {

    @RabbitHandler
    public void onMessage(ClustingMessage message){
        log.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
    }

}
