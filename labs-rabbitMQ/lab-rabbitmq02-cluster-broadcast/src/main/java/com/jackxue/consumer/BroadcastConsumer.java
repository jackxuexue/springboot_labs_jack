package com.jackxue.consumer;

import com.jackxue.message.BroadcastMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(
                        name = BroadcastMessage.QUEUE + "-" + "#{T(java.util.UUID).randomUUID()}",
                        autoDelete = "true"
                ),
                exchange = @Exchange(
                        name = BroadcastMessage.EXCHANGE,
                        type = ExchangeTypes.TOPIC,
                        declare = "false"
                )
        )
)
public class BroadcastConsumer {

    @RabbitHandler
    public void onMessage(BroadcastMessage message){
        log.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
    }
}
