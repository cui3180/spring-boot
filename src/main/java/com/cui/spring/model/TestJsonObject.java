package com.cui.spring.model;

/**
 * Created by cjs
 * Date： 2017/7/28.
 * Time： 18:08.
 */
public class TestJsonObject {
    private long id;
    private String userName;

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

    @Override
    public String toString() {
        return "TestJsonObject{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                '}';
    }
}
