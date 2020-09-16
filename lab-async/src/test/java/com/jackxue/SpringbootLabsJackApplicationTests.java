package com.jackxue;

import com.jackxue.service.DemoService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.SuccessCallback;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootLabsJackApplication.class)
class SpringbootLabsJackApplicationTests {

    private Logger logger = LoggerFactory.getLogger(SpringbootLabsJackApplicationTests.class);

    @Autowired
    private DemoService demoService;

    @Test
    void contextLoads() {

    }

    @Test
    public void test01(){
        long now = System.currentTimeMillis();
        logger.info("[task01] 开始执行");
        demoService.execute01();
        demoService.execute02();
        logger.info("[task01] 执行结束，消耗时长 {} 毫秒", System.currentTimeMillis() - now);
    }


    @Test
    void test02(){
        long now = System.currentTimeMillis();
        logger.info("[task02] 开始执行");
        demoService.execute01Async();
        demoService.execute02Async();
        logger.info("[task02] 执行结束，消耗时长 {} 毫秒", System.currentTimeMillis() - now);
    }

    @Test
    void test03() throws ExecutionException, InterruptedException {
        long now = System.currentTimeMillis();
        logger.info("[test03] 开始执行");
        Future<Integer> execute01Result = demoService.execute01AsyncWithFuture();
        Future<Integer> execute02Result = demoService.execute02AsyncWithFuture();

        Integer ret1 = execute01Result.get();
        Integer ret2 = execute02Result.get();
        demoService.execute02Async();
        logger.info("[test03] 执行结束 ret1:{} ret2:{}，消耗时长 {} 毫秒", ret1, ret2, System.currentTimeMillis() - now);
    }

    @Test
    void test04() throws ExecutionException, InterruptedException {
        long now = System.currentTimeMillis();
        logger.info("[test04] 开始执行");
        ListenableFuture<Integer> execute01Result = demoService.execute01AsyncWithListenableFuture();
        ListenableFuture<Integer> execute02Result = demoService.execute02AsyncWithListenableFuture();

        execute01Result.addCallback(new SuccessCallback<Integer>() {
            @Override
            public void onSuccess(Integer result) {
                logger.info("execute01Result onSuccess result:{}", result);
            }
        }, new FailureCallback() {
            @Override
            public void onFailure(Throwable ex) {
                logger.info("execute01Result failed result:{}", ex.getMessage());
            }
        });

        execute02Result.addCallback(new SuccessCallback<Integer>() {
            @Override
            public void onSuccess(Integer result) {
                logger.info("execute02Result onSuccess result:{}", result);
            }
        }, new FailureCallback() {
            @Override
            public void onFailure(Throwable ex) {
                logger.info("execute02Result failed result:{}", ex.getMessage());
            }
        });


        execute01Result.get();
        execute02Result.get();
        logger.info("[test04] 执行结束 消耗时长 {} 毫秒", System.currentTimeMillis() - now);
    }

    @Test
    public void testZhaoDaoNvPengYou() throws InterruptedException {
        demoService.zhaoDaoNvPengYou(1, 2);

        // sleep 1 秒，保证异步调用的执行
        Thread.sleep(1000);
    }
}
