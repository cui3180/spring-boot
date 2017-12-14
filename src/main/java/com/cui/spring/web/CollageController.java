package com.cui.spring.web;

import com.cui.fs.api.CollageService;
import com.cui.fs.model.Collage;
import com.cui.fs.util.BaseResponseVo;
import com.cui.spring.model.User;
import com.cui.spring.service.TestService;
import com.cui.spring.util.log.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * Created by cjs
 * Date： 2017/10/25.
 * Time： 15:08.
 */
@Controller
@RequestMapping("/collage")
public class CollageController {
    protected static Logger logger = LoggerFactory.getLogger(CollageController.class);
    @Autowired
    private CollageService collageService;
    @Autowired()
    private TestService testService;
    @Log
    @RequestMapping(value="/index")
    public String getUser(User user){
        user.setUserName("sfsdf");
        user.setUserName("TEST");
        try {
            testService.testMothed("TEST log",1,user);
        }catch (Exception e){
            return "/err";
        }
        return "/collage/index";
    }
    @Log
    @RequestMapping(value = "add")
    public @ResponseBody  BaseResponseVo addCollage(Collage collage){
        BaseResponseVo baseResponseVo = collageService.addCollage(collage);
        return baseResponseVo;
    }
    @RequestMapping(value="/mod")
    public String test(User user){
        user.setUserName("sfsdf");
        logger.info("Begin--getUser--user{}",user);
        return "/collage/model";
    }

}
