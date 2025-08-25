package com.assessment.ecfr_analytics.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;

import java.time.Duration;

@Configuration
public class AppConfig {

    private static final int MAX_CONNECTIONS = 2;
    private static final int MAX_PENDING_ACQUIRE_COUNT = 50;
    private static final Duration MAX_PENDING_ACQUIRE_TIMEOUT = Duration.ofSeconds(600);

    @Value("${efcr.api.base.url}")
    private String efcrApiBaseUrl;

    @Bean
    public WebClient webClient() {
        ConnectionProvider pool = ConnectionProvider.builder("custom-pool")
                .maxConnections(MAX_CONNECTIONS)
                .pendingAcquireTimeout(MAX_PENDING_ACQUIRE_TIMEOUT)
                .pendingAcquireMaxCount(MAX_PENDING_ACQUIRE_COUNT)
                .build();

        HttpClient httpClient = HttpClient.create(pool);

        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .baseUrl(efcrApiBaseUrl)
                .build();
    }
}
