package com.cui.spring.web.control;

import com.cui.spring.model.Student;
import com.cui.spring.service.fs.StudentService;
import com.cui.spring.util.BaseResponseVo;
import com.cui.spring.util.query.QueryStudent;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by cjs
 * Date： 2017/9/7.
 * Time： 11:07.
 */
@Controller
@RequestMapping(value="/student")
public class StudentController {
    private static Logger logger = LogManager.getLogger(StudentController.class.getName());
    @Autowired
    private StudentService studentService;

    @RequestMapping(value="/index")
    public String getUser(){
        return "index";
    }

    @RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public ModelAndView addTeacher(Student student){
        ModelAndView map=new ModelAndView("success");
        try{
            BaseResponseVo baseResponseVo = studentService.addStudent(student);
            if(baseResponseVo==null||!baseResponseVo.isSuccess()){
                if (baseResponseVo.getErrorCode() == -1){
                    map.addObject("res","选择人数已经满了！");
                    return map;
                }
                map.addObject("res","网络问题请重试");
            }
            map.addObject("res","选择成功");
        }catch (Exception e){
            logger.info("error--addTeacher--e:"+e);
        }
        return map;
    }

    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public ModelAndView getStudentList(QueryStudent queryStudent){
        ModelAndView map=new ModelAndView("list");
        try {
            BaseResponseVo<List<Student>> studentList = studentService.getStudentList(queryStudent);
            if (studentList==null&&!studentList.isSuccess()){
                map.addObject("res","查询失败");
                return map;
            }
            map.addObject("res","查询成功");
            map.addObject("list",studentList.getData());
        }catch (Exception e){
            logger.info("error--getStudentList--error:"+e);
        }
        return map;
    }

    @RequestMapping(value = "/del", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    public @ResponseBody String delStudent(QueryStudent student){
        try{
            BaseResponseVo baseResponseVo = studentService.delStudent(student);
            if(baseResponseVo==null||!baseResponseVo.isSuccess()){
                return "网络问题请重试";
            }
        }catch (Exception e){
            logger.info("error--addTeacher--e:"+e);
        }
        return "删除成功";
    }

}
