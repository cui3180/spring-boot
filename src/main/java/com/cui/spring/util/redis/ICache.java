package com.cui.spring.util.redis;

/**
 * Created by cjs
 * Date： 2017/12/4.
 * Time： 15:32.
 */

import redis.clients.jedis.Jedis;

import java.lang.reflect.Type;


@SuppressWarnings("rawtypes")
public interface ICache<T> {

     Jedis getResource();

     void returnResource(Jedis jedis);

     void set(String key, Object value);

    Object get(String key ,Class<T> t);

     String del(String key);

}

