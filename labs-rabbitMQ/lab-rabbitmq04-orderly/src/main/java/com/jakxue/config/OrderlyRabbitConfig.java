package com.jakxue.config;

import com.jakxue.message.OrderlyMessage;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderlyRabbitConfig {

    @Bean
    public Queue oderlyQueue0(){
        return new Queue(OrderlyMessage.QUEUE_0, true, false, false);
    }

    @Bean
    public Queue oderlyQueue1(){
        return new Queue(OrderlyMessage.QUEUE_1, true, false, false);
    }

    @Bean
    public Queue oderlyQueue2(){
        return new Queue(OrderlyMessage.QUEUE_2, true, false, false);
    }

    @Bean
    public Queue oderlyQueue3(){
        return new Queue(OrderlyMessage.QUEUE_3, true, false, false);
    }


    @Bean
    public DirectExchange ordelyExchange(){
        return new DirectExchange(OrderlyMessage.ORDER_EXCHANG, true, false);
    }

    @Bean
    public Binding ordleyBinding0(){
        return BindingBuilder.bind(oderlyQueue0()).to(ordelyExchange()).with("0");
    }

    @Bean
    public Binding ordleyBinding1(){
        return BindingBuilder.bind(oderlyQueue1()).to(ordelyExchange()).with("1");
    }

    @Bean
    public Binding ordleyBinding2(){
        return BindingBuilder.bind(oderlyQueue2()).to(ordelyExchange()).with("2");
    }

    @Bean
    public Binding ordleyBinding3(){
        return BindingBuilder.bind(oderlyQueue3()).to(ordelyExchange()).with("3");
    }
}
