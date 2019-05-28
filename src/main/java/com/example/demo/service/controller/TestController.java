package com.example.demo.service.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.demo.service.TestService;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Reference(version = "${demo.service.version}")
    private TestService testService;
    @RequestMapping("/say/{name}")
    public  String   test(@PathVariable("name") String name){
        return testService.say(name);
    }



    @Reference(version = "${demo.service.version}")
    private UserService userService;
    @RequestMapping("/user")
    public  String   testUser(){
        return userService.getInfo();
    }

}
