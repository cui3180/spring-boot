package com.cui.spring.model;


import lombok.Data;
import java.io.Serializable;

/**
 * Created by cjs
 * Date： 2017/7/12.
 * Time： 14:36.
 */
@Data
public class User implements Serializable {

    private Long id;
    private String userName;
    private String userAge;


}
