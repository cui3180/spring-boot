package com.cui.spring.web;

import com.cui.spring.model.Collage;
import com.cui.spring.service.fs.CollageService;
import com.cui.spring.util.BaseResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
    @Autowired
    private CollageService collageService;

    @RequestMapping(value="/index")
    public String getUser(){
        return "/collage/index";
    }
    @RequestMapping(value = "add")
    public @ResponseBody  String addCollage(Collage collage){
        BaseResponseVo baseResponseVo = collageService.addCollage(collage);
        return baseResponseVo.toString();
    }


}
