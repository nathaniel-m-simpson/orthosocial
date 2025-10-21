package com.assessment.orthodoxsocial.controller;

import com.assessment.orthodoxsocial.service.AnalyticsService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AnalyticsController {

    @Value("${spring.application.name}")
    private String appName;

    @Resource
    private AnalyticsService analyticsService;

    @GetMapping("/")
    public String index() {
        return appName;
    }

    @GetMapping("/refresh")
    public ResponseEntity refreshCfrData() {
        return analyticsService.performCfrDataRefresh();
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}
