package com.cui.spring.service.fs;

import com.cui.spring.model.Student;
import com.cui.spring.util.BaseResponseVo;
import com.cui.spring.util.query.QueryStudent;

import java.util.List;

/**
 * Created by cjs
 * Date： 2017/9/18.
 * Time： 15:39.
 */
public interface StudentService {
    BaseResponseVo<List<Student>> getStudentList(QueryStudent queryStudent);

    BaseResponseVo addStudent(Student student);

    BaseResponseVo delStudent(QueryStudent queryStudent);

    BaseResponseVo modStudent(Student student);


}
