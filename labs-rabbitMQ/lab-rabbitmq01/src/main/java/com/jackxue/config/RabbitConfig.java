package com.jackxue.config;

import com.jackxue.message.Demo01Message;
import com.jackxue.message.Demo02Message;
import com.jackxue.message.Demo03Message;
import org.springframework.amqp.core.*;
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

    public static class TopicExchangeDemoConfiguration{
        @Bean
        public Queue demo02Queue(){
            return new Queue(Demo02Message.QUEUE,
                    true,
                    false,
                    false);
        }
        @Bean
        public TopicExchange demo02Exchange(){
            return new TopicExchange(Demo02Message.EXCHANGE, true, false);
        }

        @Bean
        public Binding demo02Binding(){
            return BindingBuilder.bind(demo02Queue()).to(demo02Exchange()).with(Demo02Message.ROUTING_KEY);
        }
    }

    public static class FanoutExchangeDemoConfiguration{

        @Bean
        public Queue demo03QueueA(){
            return new Queue(Demo03Message.QUEUE_A, true, false, false);
        }

        @Bean
        public Queue demo03QueueB(){
            return new Queue(Demo03Message.QUEUE_B, true, false, false);
        }

        @Bean
        public FanoutExchange demo03Exchange(){
            return new FanoutExchange(Demo03Message.EXCHANGE, true, false);
        }

        @Bean
        public Binding demo03BindingA(){
            return BindingBuilder.bind(demo03QueueA()).to(demo03Exchange());
        }
        @Bean
        public Binding demo03BindingB(){
            return BindingBuilder.bind(demo03QueueB()).to(demo03Exchange());
        }

    }
}
