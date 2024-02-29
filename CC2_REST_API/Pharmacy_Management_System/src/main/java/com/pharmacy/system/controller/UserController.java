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

    @PostMapping("/add/user")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/get/users")
    public List<User> getUser() {
        return userService.getUserdetails();
    }

    @GetMapping("/find/user/{id}")
    public Optional<User> findUsers(@PathVariable Long userId) {
        return userService.findUser(userId);
    }

    @PutMapping("update/{userId}")
    public ResponseEntity<User> putUser(@PathVariable Long userId, @RequestBody User user) {
        return new ResponseEntity<>(userService.editUser(userId, user), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/user/{userId}")

    public String deleteUser(@PathVariable Long userId) {
        return userService.deleteUser(userId);
    }
        @GetMapping("/get/user/{offset}/{pagesize}")
        public ResponseEntity<List<User>> getMethodName(@PathVariable int offset,@PathVariable int pagesize) {
            return ResponseEntity.status(200).body(userService.getpage(offset,pagesize));
        }
        
        @GetMapping("/get/user/{offset}/{pagesize}/{field}")
        public ResponseEntity<List<User>> getMethod(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field) {
            return ResponseEntity.status(200).body(userService.getpagesort(offset,pagesize,field));
        }
    @GetMapping("/sort/get/users/{field}")
    public List<User> getMethodName(@PathVariable String field) {
        return userService.sortUsers(field);
    }
    

    }

