package com.ke.service.impl;

import com.ke.dao.UserDao;
import com.ke.entity.User;
import com.ke.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

    //依赖Dao
    @Resource
    private UserDao userDao;
    // 注入事务管理
    @Transactional(rollbackFor={Exception.class, RuntimeException.class})
    @Override
    public User getUser(Long uid) {
        return userDao.getUser(uid);
    }


    @Transactional(rollbackFor={Exception.class, RuntimeException.class})
    @Override
    public String saveUser(User user) {
        return userDao.saveUser(user);
    }
}
