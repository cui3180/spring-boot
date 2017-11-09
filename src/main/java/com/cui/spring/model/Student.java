package com.cui.spring.model;

import java.util.Date;

/**
 * Created by cjs
 * Date： 2017/9/7.
 * Time： 9:43.
 */
public class Student {
    private Long id;
    private Long teacherId;
    private String studentName;
    private String studentClass;
    private String studentPhone;
    private Date  updateTime;
    private Date  creatTime;
    private String teacherName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }



    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
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

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", teacherId=" + teacherId +
                ", studetName='" + studentName + '\'' +
                ", studentClass='" + studentClass + '\'' +
                ", studentPhone='" + studentPhone + '\'' +
                ", updateTime=" + updateTime +
                ", creatTime=" + creatTime +
                ", teacherName='" + teacherName + '\'' +
                '}';
    }
}
