package com.cui.spring.dao.mapper;

import com.cui.spring.model.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by cjs
 * Date： 2017/9/7.
 * Time： 9:47.
 */
@Mapper
@Component(value="teacherMapper")
public interface TeacherMapper {
     List<Teacher> getTeachList();
     int addTeacher(Teacher te);
     int updateTeacher(Teacher te);
     Teacher getTeachOne(Long id);

}
