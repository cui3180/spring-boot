package com.cui.spring.util.task;

import com.cui.spring.service.TestService;
import com.cui.spring.util.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by cjs
 * Date： 2017/12/14.
 * Time： 17:11.
 */
@Component
public class TestTask {

    @Autowired
    private TestService testService;

    @Scheduled(cron = "0/30 * * * * ?")
    @Async
    @Log
    public void getTask() {
        System.out.println("执行:"+ new Date() + Thread.currentThread().getName());
        //testService.testMothed("task",2,null);
    }
}
