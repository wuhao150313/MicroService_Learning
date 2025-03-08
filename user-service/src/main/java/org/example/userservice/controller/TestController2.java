package org.example.userservice.controller;


import jakarta.annotation.Resource;
import org.example.userservice.config.WuhaoProperties;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController2 {

    @Resource
    private WuhaoProperties wuhaoProperties;


}
