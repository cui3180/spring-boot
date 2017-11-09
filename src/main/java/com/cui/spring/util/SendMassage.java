package com.cui.spring.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * Created by cjs
 * Date： 2017/7/20.
 * Time： 11:37.
 */
@Component("sendMassage")
public class SendMassage {
    @Autowired
    private RedisTemplate stringRedisTemplate;
    @Autowired
    private CountDownLatch countDownLatch;

    public  void  send(String topic ,String msg){
        stringRedisTemplate.convertAndSend(topic,msg);
    }

}
