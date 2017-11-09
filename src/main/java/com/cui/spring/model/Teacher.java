package com.cui.spring.model;

import java.util.Date;

/**
 * Created by cjs
 * Date： 2017/9/7.
 * Time： 9:40.
 */
public class Teacher {
    private  Long id;
    private  String teacherName;
    private  String teacherRemake;
    private  Integer count;
    private  Date  updateTime;
    private  Date creatTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherRemake() {
        return teacherRemake;
    }

    public void setTeacherRemake(String teacherRemake) {
        this.teacherRemake = teacherRemake;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", teacherName='" + teacherName + '\'' +
                ", teacher_remake='" + teacherRemake + '\'' +
                ", count=" + count +
                ", updateTime=" + updateTime +
                ", creatTime=" + creatTime +
                '}';
    }
}
