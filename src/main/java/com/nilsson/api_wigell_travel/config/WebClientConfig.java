package com.nilsson.api_wigell_travel.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Value("${converter.service.url}")
    private String serviceUrl;

    @Bean
    public WebClient converterClient() {
        return WebClient.create(serviceUrl);
    }

}
