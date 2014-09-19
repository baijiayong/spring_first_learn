package com.baldurtech.contact.config;

import com.baldurtech.contact.core.service.ContactService;
import com.baldurtech.contact.core.service.ContactEventHandler;
import com.baldurtech.contact.core.domain.Contact;
import com.baldurtech.contact.events.RequestAllContactItemsEvent;
import com.baldurtech.contact.persistence.ContactPersistenceService;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreConfig {
    
	@Bean
	public ContactService contactService(ContactPersistenceService ContactPersistenceService) {
		return new ContactEventHandler(ContactPersistenceService);
	}
    
}