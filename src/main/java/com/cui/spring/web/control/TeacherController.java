package com.cui.spring.web.control;

import com.cui.spring.dao.mapper.TeacherMapper;
import com.cui.spring.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by cjs
 * Date： 2017/9/7.
 * Time： 9:38.
 */
@Controller
@RequestMapping(value="/teacher")
public class TeacherController {
    @Autowired
   private TeacherMapper teacherMapper;
    @RequestMapping(value="/index")
    public String getUser(){
        return "addteacher";
    }

    @RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public String addTeacher(Teacher teacher){
        Map<String,Object> resMap=new HashMap<String, Object>();
        if(teacher == null){
            resMap.put("msg","信息填写有误");
        }
        int i = teacherMapper.addTeacher(teacher);
        return "addteacher";
    }
    @RequestMapping(value = "/update",method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public @ResponseBody  Map updateTeacher(Teacher teacher){
        Map<String,Object> resMap=new HashMap<String, Object>();
        if(teacher == null){
            resMap.put("msg","信息填写有误");
            return resMap;
        }
        int i = teacherMapper.updateTeacher(teacher);
        return null;
    }

    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public @ResponseBody  Map getTeacherList(){
        Map<String,Object> resMap=new HashMap<String, Object>();
        try {
            List<Teacher> teachList = teacherMapper.getTeachList();
            resMap.put("list",teachList);
        }catch (Exception e){
            resMap.put("msg","网络问题请重试");
        }
        return resMap;
    }
    @RequestMapping(value = "/get", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public   ModelAndView  getTeacher(Long id){
        Map<String,Object> resMap=new HashMap<String, Object>();
        if(id==null){
            return null;
        }
        ModelAndView map =new ModelAndView();
        try {
            Teacher teachOne = teacherMapper.getTeachOne(id);
            map.addObject("teachOne",teachOne);
            map.setViewName("msg");
        }catch (Exception e){
            resMap.put("msg","网络问题请重试");
        }
        return map;
    }


}
