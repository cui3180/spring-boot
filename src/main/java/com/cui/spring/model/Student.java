package com.cui.spring.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by cjs
 * Date： 2017/9/7.
 * Time： 9:43.
 */
@Data
public class Student {
    private Long id;
    private Long teacherId;
    private String studentName;
    private String studentClass;
    private String studentPhone;
    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date  updateTime;
    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date  createTime;
    private String teacherName;

}
