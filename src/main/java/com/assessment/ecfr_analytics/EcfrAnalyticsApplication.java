package com.assessment.ecfr_analytics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class EcfrAnalyticsApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcfrAnalyticsApplication.class, args);
    }

}
