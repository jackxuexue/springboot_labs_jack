package com.jackxue.demo01;

import com.jackxue.RabbitMqMain01;
import com.jackxue.producer.Demo01Puducer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RabbitMqMain01.class})
@Slf4j
public class Demo01Test {
    @Autowired
    private Demo01Puducer demo01Puducer;

    @Test
    public void test01() throws InterruptedException {
        int id = (int) (System.currentTimeMillis() / 1000);
        demo01Puducer.syncSend(id);
        log.info("[testSyncSend][发送编号：[{}] 发送成功]", id);

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }
}
