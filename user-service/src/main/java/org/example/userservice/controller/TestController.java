package org.example.userservice.controller;



import jakarta.annotation.Resource;
import org.example.userservice.config.WuhaoProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RefreshScope
public class TestController {
//    @Value("${wuhao.username}")
//    private String username;
//
//    @Value("${wuhao.job}")
//    private String job;

    @Resource
    private WuhaoProperties wuhaoProperties;

    @GetMapping("/test")
    public String get() {
        return "读取到的配置中心的值:  " + wuhaoProperties.getUsername() + "," + wuhaoProperties.getJob();
    }

}
