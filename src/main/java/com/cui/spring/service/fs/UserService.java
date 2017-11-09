package com.cui.spring.service.fs;

import com.cui.spring.model.User;

/**
 * Created by cjs
 * Date： 2017/7/12.
 * Time： 15:05.
 */
public interface UserService {
    /**
     * 获取用户
     */
    User getUser(Long id);
     int addUser(User us);
    User getUserByName(String name);
}
