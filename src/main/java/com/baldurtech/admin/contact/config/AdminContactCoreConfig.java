package com.baldurtech.admin.contact.config;

import com.baldurtech.admin.contact.core.service.AdminContactService;
import com.baldurtech.admin.contact.core.service.AdminContactEventHandler;
import com.baldurtech.admin.contact.persistence.AdminContactPersistenceService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdminContactCoreConfig {
    @Bean
    public AdminContactService adminContactSerice(AdminContactPersistenceService adminContactPersistenceService) {
        return new AdminContactEventHandler(adminContactPersistenceService);
    }
}