package com.jackxue.demo03;

import com.jackxue.RabbitMqMain01;
import com.jackxue.producer.Demo03Producer;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitMqMain01.class)
public class Demo03Test {
    private final Logger logger = LoggerFactory.getLogger(Demo03Test.class);
    @Autowired
    private Demo03Producer producer;
    @Test
    public void testSysnSend() throws InterruptedException {
        int id = (int) (System.currentTimeMillis()/1000);
        producer.syncSend(id);
        logger.info("[testSysnSend] 发送编号[{}] 发送成功", id);
        new CountDownLatch(1).await();
    }
}
