package com.assessment.ecfr_analytics.controller;

import com.assessment.ecfr_analytics.service.AnalyticsService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//Please write code to download the current eCFR data, store the data server-side, create APIs that can
//retrieve the server-side stored data, and provide a UI to analyze it for items such as word count per
//agency, historical changes over time, and a checksum for each agency.
// Only implement analysis that would provide meaningful information to the user.
// Please add at least one of your own custom metrics that you believe may help inform decision-
//making more effectively.

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
}
