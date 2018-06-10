package com.ke.dao;

import com.ke.entity.User;

public interface UserDao {
    User getUser(Long uid);

    String saveUser(User user);
}
