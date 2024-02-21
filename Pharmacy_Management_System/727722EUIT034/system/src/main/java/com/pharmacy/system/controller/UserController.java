package com.pharmacy.system.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.pharmacy.system.model.User;
import com.pharmacy.system.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/add_user")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/get_users")
    public List<User> getUser() {
        return userService.getUserdetails();
    }

    @GetMapping("/finduser/{userId}")
    public Optional<User> findUsers(@PathVariable Long userId) {
        return userService.findUser(userId);
    }

    @PutMapping("update/{userId}")
    public ResponseEntity<User> putUser(@PathVariable Long userId, @RequestBody User user) {
        return new ResponseEntity<>(userService.editUser(userId, user), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteuser/{userId}")

    public String deleteUser(@PathVariable Long userId) {
        return userService.deleteUser(userId);
    }

}
