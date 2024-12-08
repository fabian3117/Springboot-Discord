package com.example.discord_webhook.settings;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    /*
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
            .messageConverters(new MappingJackson2HttpMessageConverter())
            .build();
    }

     */
    @Bean
    public RestTemplate restTemplate() {
        RestTemplateBuilder builder = new RestTemplateBuilder();
        return builder.messageConverters(new MappingJackson2HttpMessageConverter()).build();
//        return new RestTemplate().bui;
    }
}
