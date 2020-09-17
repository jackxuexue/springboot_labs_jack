package com.jakxue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync // 开启异步
public class OrderlyMQMain {
    public static void main(String[] args) {
        SpringApplication.run(OrderlyMQMain.class, args);
    }
}
