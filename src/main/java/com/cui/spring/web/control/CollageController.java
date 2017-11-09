package com.cui.spring.web.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by cjs
 * Date： 2017/10/25.
 * Time： 15:08.
 */
@Controller
@RequestMapping("/collage")
public class CollageController {

    @RequestMapping(value="/index")
    public String getUser(){
        return "/collage/index";
    }

}
