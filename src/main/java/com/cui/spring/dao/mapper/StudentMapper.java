package com.cui.spring.dao.mapper;

import com.cui.spring.model.Student;
import com.cui.spring.util.query.QueryStudent;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by cjs
 * Date： 2017/9/7.
 * Time： 9:50.
 */
@Mapper
@Component(value="studentMapper")
public interface StudentMapper {
     List<Student> getStudentList(QueryStudent student);
     int addStudent(Student st);
     int getTeacherId(Student st);
     int delStudent(Integer id);
     int updateStudent(Student st);
}
