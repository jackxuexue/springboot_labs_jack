package com.jackxue.demo01;

import com.jackxue.RabbitMqMain01;
import com.jackxue.producer.Demo01Puducer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.SuccessCallback;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

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

    @Test
    public void test02() throws ExecutionException, InterruptedException {
        int id = (int) (System.currentTimeMillis() / 1000);
        ListenableFuture<Void> future = demo01Puducer.asyncSend(id);
        future.addCallback(new SuccessCallback<Void>() {
            @Override
            public void onSuccess(Void result) {
                log.info("[test02][发送编号：[{}] 发送成功]", id);
            }
        }, null);

        future.get();
    }
}
