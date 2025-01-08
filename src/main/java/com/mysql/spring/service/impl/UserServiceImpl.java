package com.mysql.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mysql.spring.entity.User;
import com.mysql.spring.repository.UserRepository;
import com.mysql.spring.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void storeUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Integer id) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid User Id " + id));
        return user;
    }

    @Override
    public void updateUser(Integer id, User user) {
        userRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid User Id " + id));
        user.setId(id);
        userRepository.save(user);
    }

    @Override
    public void destroyUser(Integer id) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid User Id " + id));
        userRepository.delete(user);
    }

}
