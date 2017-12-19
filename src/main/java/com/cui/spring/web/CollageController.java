package com.cui.spring.web;

import com.cui.fs.api.CollageService;
import com.cui.fs.model.Collage;
import com.cui.fs.util.BaseResponseVo;
import com.cui.spring.model.User;
import com.cui.spring.service.TestService;
import com.cui.spring.util.exception.ServiceException;
import com.cui.spring.util.log.InterceptorAdmin;
import com.cui.spring.util.log.Log;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * Created by cjs
 * Date： 2017/10/25.
 * Time： 15:08.
 */
@Controller
@RequestMapping("/collage")
@Slf4j
public class CollageController  {
    @Autowired
    private CollageService collageService;
    @Autowired
    private TestService testService;



    @Log
    @RequestMapping(value="/index",method = {RequestMethod.POST, RequestMethod.GET})
    public String getUser(User user){
        user.setUserName("sfsdf");
        user.setUserName("TEST");
        testService.testMothed("TEST log",1,user);
        return "/collage/index";
    }
    @Log
    @RequestMapping(value = "add",method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody  BaseResponseVo addCollage(Collage collage){
        BaseResponseVo baseResponseVo = collageService.addCollage(collage);
        return baseResponseVo;
    }
    @RequestMapping(value="/mod",method = {RequestMethod.POST, RequestMethod.GET})
    public String test(User user){
        user.setUserName("sfsdf");
        log.info("Begin--getUser--user{}",user);
        return "/collage/model";
    }

}
