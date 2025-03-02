package org.example.userservice.controller;

import lombok.AllArgsConstructor;
import org.example.userservice.entity.User;
import org.example.userservice.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController

public class UserController2 {


    private UserService userService;

    // 通过id获取用户信息
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable int id) {
        User user = userService.getById(id);
        System.out.println("查询到的用户信息: " + user);  // 打印查询到的对象
        return user;

    }


}
