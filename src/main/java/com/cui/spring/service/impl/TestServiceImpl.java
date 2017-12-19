package com.cui.spring.service.impl;

import com.cui.spring.dao.mapper.TestMapper;
import com.cui.spring.model.Test;
import com.cui.spring.model.User;
import com.cui.spring.service.TestService;
import com.cui.spring.util.BaseResponseVo;
import com.cui.spring.util.exception.ServiceException;
import com.cui.spring.util.log.Log;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by cjs
 * Date： 2017/12/14.
 * Time： 16:01.
 */
@Service("testServiceImpl")
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    @Log
    public BaseResponseVo testMothed(String ad , Integer type , User user) {
        BaseResponseVo baseResponseVo =new BaseResponseVo();
        baseResponseVo.setIsSuccess(true);
        baseResponseVo.setMessage("I AM TEST!");
        if(type == 1){
            throw  new RuntimeException("LOG TEST ERROR");
        }
        return baseResponseVo;
    }

    @Log
    @Override
    public BaseResponseVo testInterceptor(String str) {
        BaseResponseVo baseResponseVo =new BaseResponseVo();
        baseResponseVo.setIsSuccess(false);
        return baseResponseVo;
    }

    /**
     * addTest
     *
     * @param test
     * @return
     */
    @Log
    @Override
    public BaseResponseVo addTest(Test test) {
        BaseResponseVo responseVo =new BaseResponseVo();
        int i = testMapper.addTest(test);
        responseVo.setIsSuccess(true);
        responseVo.setData(i);
        return responseVo;
    }
}
