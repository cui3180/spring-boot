package com.cui.spring.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by cjs
 * Date： 2017/9/7.
 * Time： 9:40.
 */
@Data
public class Teacher {
    private  Long id;
    private  String teacherName;
    private  String teacherRemake;
    private  Integer count;
    private  Date  updateTime;
    private  Date createTime;
}
