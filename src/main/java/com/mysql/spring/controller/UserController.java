package com.mysql.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.spring.entity.User;
import com.mysql.spring.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/store")
    public String storeUser(@RequestBody User user) {
        userService.storeUser(user);
        return "created";
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id) {
        return userService.getUser(id);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<Void> updateUser(@PathVariable Integer id, @RequestBody User user) {
        userService.updateUser(id, user);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}/destroy")
    public ResponseEntity<Void> destroyUser(@PathVariable Integer id) {
        userService.destroyUser(id);
        return ResponseEntity.noContent().build();
    }
}
