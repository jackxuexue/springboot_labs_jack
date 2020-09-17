package com.jackxue.demo02;

import com.jackxue.RabbitMqMain01;
import com.jackxue.producer.Demo02Producer;
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
public class Demo02Test {
    @Autowired
    private Demo02Producer demo02Puducer;

    @Test
    public void test01() throws InterruptedException {
        int id = (int) (System.currentTimeMillis() / 1000);
        demo02Puducer.syncSend(id, "jackxue.yu.nai");
        log.info("[test01] 发送编号：[{}] 发送成功", id);
        new CountDownLatch(1).await();
    }

}
