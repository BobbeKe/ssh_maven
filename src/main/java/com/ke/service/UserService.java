package com.ke.service;

import com.ke.entity.User;

public interface UserService {
    User getUser(Long uid);

    String saveUser(User user);
}
