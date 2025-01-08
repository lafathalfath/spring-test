package com.mysql.spring.service;

import java.util.List;

import com.mysql.spring.entity.User;

public interface UserService {
    void storeUser(User user);

    List<User> getAllUsers();

    User getUser(Integer id);

    void updateUser(Integer id, User user);

    void destroyUser(Integer id);
}
