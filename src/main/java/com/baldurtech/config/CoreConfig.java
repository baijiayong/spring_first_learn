package com.baldurtech.config;

import com.baldurtech.core.ContactService;
import com.baldurtech.core.Contact;
import com.baldurtech.events.RequestAllContactItemsEvent;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreConfig {
    @Bean
    public ContactService mockContactService() {
        return new ContactService() {
            public List<Contact> allContactList(RequestAllContactItemsEvent requestAllContactItemsEvent) {
                return new ArrayList<Contact>();
            }
        };
    }
}