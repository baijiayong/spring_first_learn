package com.baldurtech.contact.config;

import com.baldurtech.contact.repository.ContactRepository;
import com.baldurtech.contact.repository.ContactMemoryRepository;
import com.baldurtech.contact.persistence.ContactPersistenceService;
import com.baldurtech.contact.persistence.ContactPersistenceEventHandler;

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