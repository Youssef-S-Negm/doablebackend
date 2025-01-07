package com.youssef.doablebackend.service;

import com.youssef.doablebackend.entity.User;

public interface IUserService {

    void save(User user);

    User findById(String id);

    void deleteById(String id);
}
