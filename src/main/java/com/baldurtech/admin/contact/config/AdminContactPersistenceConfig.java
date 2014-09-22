package com.baldurtech.admin.contact.config;

import com.baldurtech.admin.contact.persistence.AdminContactPersistenceService;
import com.baldurtech.admin.contact.persistence.AdminContactPersistenceEventHandler;
import com.baldurtech.admin.contact.repository.AdminContactRepository;
import com.baldurtech.admin.contact.repository.AdminContactMemoryRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdminContactPersistenceConfig {
    @Bean
    public AdminContactRepository adminContactRepository() {
        return new AdminContactMemoryRepository();
    }
    @Bean
    public AdminContactPersistenceService adminContactPersistenceService(AdminContactRepository adminContactRepository) {
        return new AdminContactPersistenceEventHandler(adminContactRepository);
    }  
}