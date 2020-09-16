package com.jackxue.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.Future;

@Service
public class DemoService {
    private Logger logger = LoggerFactory.getLogger(DemoService.class);

    @Async
    public Integer zhaoDaoNvPengYou(Integer a, Integer b){
        throw new RuntimeException("程序员不需要女朋友");
    }

    @Async
    public ListenableFuture<Integer> execute01AsyncWithListenableFuture(){
        try {
            return AsyncResult.forValue(this.execute01());
        }catch (Throwable ex){
            return AsyncResult.forExecutionException(ex);
        }
    }

    @Async
    public ListenableFuture<Integer> execute02AsyncWithListenableFuture(){
        try {
            return AsyncResult.forValue(this.execute02());
        }catch (Throwable ex){
            return AsyncResult.forExecutionException(ex);
        }
    }

    @Async
    public Future<Integer> execute01AsyncWithFuture(){
        return AsyncResult.forValue(this.execute01());
    }

    @Async
    public Future<Integer> execute02AsyncWithFuture(){
        return AsyncResult.forValue(this.execute02());
    }



    @Async
    public Integer execute01Async(){
        return this.execute01();
    }

    @Async
    public Integer execute02Async(){
        return this.execute02();
    }

    public Integer execute01(){
        logger.info("thread[{}] start to run 01", Thread.currentThread().getName());
        sleep(10);
        logger.info("run 01 finish!");
        return 1;
    }

    public Integer execute02(){
        logger.info("thread[{}] start to run 02", Thread.currentThread().getName());
        sleep(5);
        logger.info("run 02 finish!");
        return 2;
    }

    public void sleep(Integer seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
