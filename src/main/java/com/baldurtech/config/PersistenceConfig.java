package com.baldurtech.config;

import com.baldurtech.repository.ContactRepository;
import com.baldurtech.repository.ContactMemoryRepository;
import com.baldurtech.persistence.ContactPersistenceService;
import com.baldurtech.persistence.ContactPersistenceEventHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceConfig {    
    @Bean
	public ContactRepository contactRepository() {
		return new ContactMemoryRepository();
	}
    
    @Bean
	public ContactPersistenceService ContactPersistenceService(ContactRepository ContactRepository) {
		return new ContactPersistenceEventHandler(ContactRepository);
	}
}