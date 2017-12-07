package com.cui.spring.util.redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.lang.reflect.Type;
import java.net.Proxy;

/**
 * Created by cjs
 * Date： 2017/12/4.
 * Time： 16:20.
 */
@Service("redisServiceImpl")
public class RedisServiceImpl<T> implements  ICache<T>{
    protected static Logger logger = LoggerFactory.getLogger(RedisServiceImpl.class);

    @Autowired
    private JedisPool jedisPool;

    @Override
    public Jedis getResource() {
        return jedisPool.getResource();
    }

    @SuppressWarnings("deprecation")
    @Override
    public void returnResource(Jedis jedis) {
        if(jedis != null){
            jedisPool.returnResourceObject(jedis);
        }
    }

    @Override
    public void set(String key, Object value) {
        Jedis jedis=null;
        try{

            jedis = getResource();
            jedis.set(key, JSON.toJSONString(value));
            logger.info("Redis set success - " + key + ", value:" + value);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Redis set error: "+ e.getMessage() +" - " + key + ", value:" + value);
        }finally{
            returnResource(jedis);
        }
    }

    @Override
    public Object get(String key,Class<T> t) {
        Object result = null;
        Jedis jedis=null;
        try{
            jedis = getResource();
            JSONObject jsonObject = (JSONObject)JSON.parse(jedis.get(key));
            result = JSONObject.toJavaObject(jsonObject, Class.forName(t.getName()));
            logger.info("Redis get success - " + key + ", value:" + result);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Redis set error: "+ e.getMessage() +" - " + key + ", value:" + result);
        }finally{
            returnResource(jedis);
        }
        return result;
    }

    @Override
    public String del(String key) {
        String result = null;
        Jedis jedis=null;
        try{
            jedis = getResource();
            jedis.del(key);
            logger.info("Redis get success - " + key + ", value:" + result);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Redis set error: "+ e.getMessage() +" - " + key + ", value:" + result);
        }finally{
            returnResource(jedis);
        }
        return result;
    }
}
