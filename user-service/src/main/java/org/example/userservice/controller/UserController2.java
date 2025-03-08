package org.example.userservice.controller;

import lombok.AllArgsConstructor;
import org.example.userservice.config.WuhaoProperties;
import org.example.userservice.entity.User;
import org.example.userservice.response.ApiResponse;
import org.example.userservice.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController

public class UserController2 {


    private UserService userService;
    private final WuhaoProperties wuhaoProperties;

//     通过id获取用户信息
//    @GetMapping("/user/{id}")
//    public User getUserById(@PathVariable int id) {
//        User user = userService.getById(id);
//        System.out.println("查询到的用户信息: " + user);  // 打印查询到的对象
//        return user;
//
//    }

    @GetMapping({"/user", "/user/{id}"})
    public ApiResponse<User> getUserById(@PathVariable(required = false) Integer id) {
        // 检查服务开关
        if (!wuhaoProperties.isServiceFlag()) {
            return ApiResponse.maintenance();
        }

        // 如果 id 为空，则返回 404
        if (id == null) {
            return ApiResponse.notFound();
        }

        User user = userService.getById(id);
        if (user != null) {
            return ApiResponse.success(user);
        } else {
            return ApiResponse.notFound();
        }
    }

}
