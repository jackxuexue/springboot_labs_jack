package com.jackxue.producer;

import com.jackxue.CBRabbitMain;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CBRabbitMain.class)
@Slf4j
public class ClusteringProducerTest {

    @Autowired
    private ClusteringProducer producer;

    @Test
    public void mock() throws InterruptedException {
        new CountDownLatch(1).await();
    }
    @Test
    public void testSyncSend() throws InterruptedException {
        // 发送 3 条消息
        for (int i = 0; i < 3; i++) {
            producer.syncSend(i+1000);
            log.info("[testSyncSend][发送编号：[{}] 发送成功]", i+1000);
        }

        new CountDownLatch(1).await();
    }
}
