package com.jackxue.producer;

import com.jakxue.OrderlyMQMain;
import com.jakxue.producer.OrderlyProducer;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderlyMQMain.class)
public class OrderlyProducerTest {

    @Autowired
    private OrderlyProducer producer;

    @Test
    public void testSyncSend() throws InterruptedException {
        for (int i = 0; i < 2; i++) {
            for (int id = 0; id < 4; id++) {
                producer.syncSend(id);
            }
            Thread.sleep(1000);
        }
        new CountDownLatch(1).await();
    }
}
