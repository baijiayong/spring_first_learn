package com.baldurtech.department.config;

import com.baldurtech.department.core.service.DepartmentService;
import com.baldurtech.department.persistence.DepartmentPersistenceService;
import com.baldurtech.department.core.service.DepartmentEventHandler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DepartmentCoreConfig {
    @Bean
    public DepartmentService departmentService(DepartmentPersistenceService departmentPersistenceService){
        return new DepartmentEventHandler(departmentPersistenceService);
    }
}