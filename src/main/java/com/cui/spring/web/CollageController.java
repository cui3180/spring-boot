package com.cui.spring.web;

import com.cui.fs.api.CollageService;
import com.cui.fs.model.Collage;
import com.cui.fs.util.BaseResponseVo;
import com.cui.spring.model.User;
import com.cui.spring.util.log.Log;
import com.spring.cui.fs.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    private TestService testService;



    @Log
    @RequestMapping(value="/index",method = {RequestMethod.POST, RequestMethod.GET})
    public String getUser(User user){
        user.setUserName("sfsdf");
        user.setUserName("TEST");
        com.spring.cui.fs.vo.BaseResponseVo responseVo = testService.testMothed("11", 2);
        log.info("responseVo{}",responseVo);
        return "/collage/index";
    }
    @Log
    @RequestMapping(value = "add",method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody  BaseResponseVo addCollage(Collage collage){
        return null;
    }
    @RequestMapping(value="/mod",method = {RequestMethod.POST, RequestMethod.GET})
    public String test(User user){
        user.setUserName("sfsdf");
        log.info("Begin--getUser--user{}",user);
        return "/collage/model";
    }

}
