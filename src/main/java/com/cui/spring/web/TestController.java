package com.cui.spring.web;

import com.cui.spring.model.Test;
import com.cui.spring.model.User;
import com.cui.spring.service.TestService;
import com.cui.spring.util.BaseResponseVo;
import com.cui.spring.util.log.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by cjs
 * Date： 2017/12/19.
 * Time： 16:15.
 */
@Slf4j
@Controller
@RequestMapping(value = "/test")
public class TestController {
     @Autowired
     private TestService testService;


    @RequestMapping(value = "/index",method = {RequestMethod.POST, RequestMethod.GET})
    public BaseResponseVo test(User user){
        log.info("我是测试啊");
        return testService.testMothed("",1,user);
    }


    @RequestMapping(value = "/rest",method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody  BaseResponseVo rest(User user){
        log.info("我是测试啊");
        return testService.testInterceptor("");
    }


    @RequestMapping(value = "/add",method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody  BaseResponseVo add(Test test){
        return testService.addTest(test);
    }
}
