package com.as.techheaven.productserviceapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientsConfig {

    @Bean
    public WebClient webClient() {
        return WebClient.builder().build();
    }

}
