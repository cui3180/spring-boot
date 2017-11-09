package com.cui.spring.model;


import java.io.Serializable;

/**
 * Created by cjs
 * Date： 2017/7/12.
 * Time： 14:36.
 */
public class User implements Serializable {

    private long id;
    private String userName;
    private String userAge;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userAge='" + userAge + '\'' +
                '}';
    }
}
