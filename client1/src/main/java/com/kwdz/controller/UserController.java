package com.kwdz.controller;

import com.kwdz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/{userid}")
    public String getUser(@PathVariable(value = "userid") String userid) {
        return userService.findByUserId(userid).getUserName();
    }
}
