package com.jackxue.config;

import com.jackxue.message.Demo01Message;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {
    public static class DirectExchangeDemoConfiguration{

        @Bean
        public Queue demo01Queue(){
            return new Queue(Demo01Message.QUEUE,
                    true, //durable 是否持久化
                    false, //exclusive 是否排他
                    false); //autoDelete是否自动删除
        }

        @Bean
        public DirectExchange demo01Exchange(){
            return new DirectExchange(Demo01Message.EXCHANGE,
                    true,  //durable 是否持久化
                    false); //autoDelete是否自动删除
        }

        @Bean
        public Binding demo01Binding(){
            return BindingBuilder.bind(demo01Queue()).to(demo01Exchange()).with(Demo01Message.ROUTING_KEY);
        }
    }
}
