package com.baldurtech;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreConfig {
    @Bean
    public ContactService mockContactService() {
        return new ContactService() {
            public String getMessage() {
                return "Hi, contact!";
            }
        };
    }
}