package com.jackxue.producer;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;

@SpringBootTest
@Slf4j
public class ConcurrentProducerTest {
    @Autowired
    private ConcurrentProducer producer;

    @Test
    public void testSyncSend() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            long id = 10000;
            producer.syncSend(id+i);
            log.info("发送消息 编号：[{}] 发送成功", id+i);
        }
        new CountDownLatch(1).await();
    }
}
