package com.cui.spring.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by cjs
 * Date： 2017/10/25.
 * Time： 13:55.
 */
@Data
public class Collage implements Serializable {

    private Integer id;//id
    private String name;//姓名
    private String phone;//电话
    private Integer    status;//就业情况
    private Integer    sex ;//性别
    private String company;//就业单位
    private String workType;//就业形式
    private String number;//学号
    private String remark;//专业
    private String yn;
    private Date createTime;
    private Date updateTime;

}
