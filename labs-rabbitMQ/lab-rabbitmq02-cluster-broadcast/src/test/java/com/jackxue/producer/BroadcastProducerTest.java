package com.jackxue.producer;

import com.jackxue.CBRabbitMain;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CBRabbitMain.class)
@Slf4j
public class BroadcastProducerTest {

    @Autowired
    private BroadcastProducer producer;

    @Test
    public void mock() throws InterruptedException {
        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }

    @Test
    public void testSyncSend() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            long id = System.currentTimeMillis();
            producer.syncSend(id);
            log.info("[testSyncSend][发送编号：[{}] 发送成功]", id);
        }
        new CountDownLatch(1).await();
    }
}
