package com.cui.spring.web;

import com.cui.fs.api.CollageService;
import com.cui.fs.model.Collage;
import com.cui.fs.model.User;
import com.cui.fs.util.BaseResponseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value="/index")
    public String getUser(User user){
        user.setUserName("sfsdf");
        logger.info("Begin--getUser--user{}",user);
        return "/collage/index";
    }
    @RequestMapping(value = "add")
    public @ResponseBody  BaseResponseVo addCollage(Collage collage){
        BaseResponseVo baseResponseVo = collageService.addCollage(collage);
        return baseResponseVo;
    }


}
