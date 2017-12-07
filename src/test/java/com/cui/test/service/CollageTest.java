package com.cui.test.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.cui.fs.api.CollageService;
import com.cui.fs.model.Collage;
import com.cui.fs.util.BaseResponseVo;
import com.cui.spring.util.redis.ICache;
import com.cui.test.AbstractBaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by cjs
 * Date： 2017/11/9.
 * Time： 14:07.
 */
public class CollageTest extends AbstractBaseTest {
    @Autowired
    private CollageService collageService;

    @Test
    public void testAddCollage(){
        Collage collage=new Collage();
        collage.setUpdateTime(new Date());
        collage.setCompany("test");
        collage.setName("sasfsa");
        collage.setPhone("1213121312312");
        collage.setRemark("test");
        collage.setSex(1);
        collage.setStatus(1);
        collage.setWorkType("jiaoyu");
        BaseResponseVo baseResponseVo = collageService.addCollage(collage);
        System.out.print(baseResponseVo);
    }

    @Autowired
    private ICache redisServiceImpl;

    @Test
    public  void  getTest(){
        Collage collage=new Collage();
        collage.setUpdateTime(new Date());
        collage.setCompany("test");
        collage.setName("sasfsa");
        collage.setPhone("1213121312312");
        collage.setRemark("test");
        collage.setSex(1);
        collage.setStatus(1);
        collage.setWorkType("jiaoyu");
        redisServiceImpl.set("test01", collage);
        Collage test01 =(Collage)redisServiceImpl.get("test01",Collage.class);
        System.out.print(test01.getCompany()+"11111111111111111111111111111111111111111111111");
    }

}
