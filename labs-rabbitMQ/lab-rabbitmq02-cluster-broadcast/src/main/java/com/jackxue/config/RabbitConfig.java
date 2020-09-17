package com.jackxue.config;

import com.jackxue.message.BroadcastMessage;
import com.jackxue.message.ClustingMessage;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static class ClustingConfiguration{

        @Bean
        public TopicExchange clusteringExchange(){
            return new TopicExchange(ClustingMessage.EXCHANGE, true, false);
        }
    }

    public static class BroadcastConfiguration{

        @Bean
        public TopicExchange broadcastExchange(){
            return new TopicExchange(BroadcastMessage.EXCHANGE, true, false);
        }

    }
}
