package com.jackxue.consumer;

import com.jackxue.message.Demo01Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

@Component
@RabbitListener(queues = {Demo01Message.QUEUE})
@Slf4j
public class Demo01Consumer {

//    @RabbitHandler
//    public void onMessage(Demo01Message message){
//        log.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
//    }

    @RabbitHandler(isDefault = true)
    public void onDefaultMessage(Message message) throws IOException, ClassNotFoundException {
        log.info("[onMessage][线程编号:{} 消息内容：{}  消息body{}]", Thread.currentThread().getId(), message);


        ByteArrayInputStream bis = new ByteArrayInputStream(message.getBody());
        ObjectInputStream ois = new ObjectInputStream(bis);
        Demo01Message message1 = (Demo01Message) ois.readObject();
        log.info("反序列化后的消息为：{}", message1);
    }
}
