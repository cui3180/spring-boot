package com.cui.spring.service.impl;

import com.cui.spring.dao.mapper.UserMapper;
import com.cui.spring.model.User;
import com.cui.spring.service.fs.UserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * Created by cjs
 * Date： 2017/7/12.
 * Time： 15:06.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    private static Logger logger = LogManager.getLogger(UserServiceImpl.class);
    @Resource
    private UserMapper  userMapper;
    /**
     * 获取用户
     * @param id
     */
    @Override
    public User getUser(Long id) {
        logger.info("*******************"+id+"*******************");
        return userMapper.getOne(id);
    }

    @Override
    public int addUser(User us) {
        return userMapper.insert(us);
    }

    @Override
    public User getUserByName(String name) {
        User user =new User();
        user.setUserName(name);
        return userMapper.getUserByName(user);
    }
}
