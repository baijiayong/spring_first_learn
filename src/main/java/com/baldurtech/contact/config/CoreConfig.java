package com.baldurtech.contact.config;

import com.baldurtech.contact.core.service.ContactService;
import com.baldurtech.contact.core.service.ContactEventHandler;
import com.baldurtech.contact.persistence.ContactPersistenceService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreConfig {
    
	@Bean
	public ContactService contactService(ContactPersistenceService ContactPersistenceService) {
		return new ContactEventHandler(ContactPersistenceService);
	}
    
}