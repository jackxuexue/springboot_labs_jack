package com.jackxue.config;

import com.jackxue.message.DemoMessage;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    @Bean
    public Queue demoQueue(){
        return new Queue(DemoMessage.QUEUE, true, false, false);
    }

    @Bean
    public DirectExchange demodExchange(){
        return new DirectExchange(DemoMessage.EXCHANGE, true, false);
    }

    @Bean
    public Binding demoBinding(){
        return BindingBuilder.bind(demoQueue()).to(demodExchange()).with(DemoMessage.ROUTE_KEY);
    }
}
