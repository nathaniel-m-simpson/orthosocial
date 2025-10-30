package com.assessment.orthodoxsocial.controller;

import com.assessment.orthodoxsocial.service.UserAccountService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    @Value("${spring.application.name}")
    private String appName;

    @Resource
    private UserAccountService userAccountService;

    @GetMapping("")
    public String index() {
        return appName;
    }

}
