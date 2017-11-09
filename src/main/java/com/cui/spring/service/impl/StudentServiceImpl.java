package com.cui.spring.service.impl;

import com.cui.spring.dao.mapper.StudentMapper;
import com.cui.spring.model.Student;
import com.cui.spring.service.fs.StudentService;
import com.cui.spring.util.BaseResponseVo;
import com.cui.spring.util.query.QueryStudent;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by cjs
 * Date： 2017/9/18.
 * Time： 15:49.
 */
@Service("studentServiceImpl")
public class StudentServiceImpl implements StudentService {
    private static Logger logger = LogManager.getLogger(StudentServiceImpl.class.getName());
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public BaseResponseVo<List<Student>> getStudentList(QueryStudent queryStudent) {
        BaseResponseVo<List<Student>> responseVo=new BaseResponseVo();
        responseVo.setIsSuccess(false);
        logger.info("Begin--getStudentList--queryStudent:{}"+queryStudent);
        try {
            List<Student> studentList = studentMapper.getStudentList(queryStudent);
            responseVo.setIsSuccess(true);
            responseVo.setData(studentList);
        }catch (Exception e){
            logger.error("error--getStudentList--e{}"+e);
            return responseVo;
        }
        return responseVo;
    }

    @Override
    @Transactional
    public BaseResponseVo addStudent(Student student) {
        BaseResponseVo responseVo=new BaseResponseVo();
        responseVo.setIsSuccess(false);
        logger.info("Begin--getStudentList--student:{}"+student);
        try {
            int count = studentMapper.getTeacherId(student);
            if (count>=3){
                //选择导师人数大于3
                responseVo.setErrorCode(-1);
                return responseVo;
            }
            int i = studentMapper.addStudent(student);
            if (i != 1){
                throw new RuntimeException("添加学生失败");
            }
            responseVo.setIsSuccess(true);
        }catch (Exception e){
            logger.error("error--getStudentList--e{}"+e);
            return responseVo;
        }
        return responseVo;
    }

    @Override
    @Transactional
    public BaseResponseVo delStudent(QueryStudent queryStudent) {
        BaseResponseVo responseVo=new BaseResponseVo();
        responseVo.setIsSuccess(false);
        logger.info("Begin--getStudentList--QueryStudent:{}"+queryStudent);
        try {
            int i = studentMapper.delStudent(queryStudent.getId());
            if (i != 1){
                throw new RuntimeException("删除学生失败");
            }
            responseVo.setIsSuccess(true);
        }catch (Exception e){
            logger.error("error--getStudentList--e{}"+e);
            return responseVo;
        }
        return responseVo;
    }

    @Override
    @Transactional
    public BaseResponseVo modStudent(Student student) {
        BaseResponseVo responseVo=new BaseResponseVo();
        responseVo.setIsSuccess(false);
        logger.info("Begin--getStudentList--student:{}"+student);
        try {
            int i = studentMapper.updateStudent(student);
            if (i != 1){
                throw new RuntimeException("修改学生失败");
            }
            responseVo.setIsSuccess(true);
        }catch (Exception e){
            logger.error("error--getStudentList--e{}"+e);
            return responseVo;
        }
        return responseVo;
    }
}
