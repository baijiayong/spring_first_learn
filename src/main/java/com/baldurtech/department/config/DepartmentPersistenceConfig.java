package com.baldurtech.department.config;

import com.baldurtech.department.repository.DepartmentRepository;
import com.baldurtech.department.repository.DepartmentMemoryRepository;
import com.baldurtech.department.persistence.DepartmentPersistenceService;
import com.baldurtech.department.persistence.DepartmentPersistenceEventHandler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DepartmentPersistenceConfig {
    @Bean
    public DepartmentRepository departmentRepository() {
        return new DepartmentMemoryRepository();
    }
    
    @Bean
    public DepartmentPersistenceService departmentPersistenceService(DepartmentRepository dePartmentRepository){
        return new DepartmentPersistenceEventHandler(dePartmentRepository);
    }
}