package com.assessment.orthodoxsocial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class OrthodoxSocialApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrthodoxSocialApplication.class, args);
    }

}
