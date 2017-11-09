package com.cui.spring.util.query;

import com.cui.spring.util.PageInfo;

/**
 * Created by cjs
 * Date： 2017/9/18.
 * Time： 15:47.
 */
public class QueryTeacher extends PageInfo {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
