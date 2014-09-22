package com.baldurtech.admin.contact.core.service;

import com.baldurtech.contact.events.RequestAllContactItemsEvent;
import com.baldurtech.contact.events.AllContactsListEvent;
import com.baldurtech.contact.events.RequestContactDetailsEvent;
import com.baldurtech.contact.events.ContactDetailsEvent;
import com.baldurtech.admin.contact.persistence.AdminContactPersistenceService;
import com.baldurtech.contact.core.domain.Contact;

public class AdminContactEventHandler implements AdminContactService {
    AdminContactPersistenceService adminContactPersistenceService;
    
    public AdminContactEventHandler (AdminContactPersistenceService adminContactPersistenceService) {
        this.adminContactPersistenceService = adminContactPersistenceService;
    }
    
    @Override
    public AllContactsListEvent allContactsList(RequestAllContactItemsEvent requestAllContactItemsEvent) {
        return adminContactPersistenceService.requestAllContactsList(requestAllContactItemsEvent);
    }
    
    @Override
    public ContactDetailsEvent contactDetails(RequestContactDetailsEvent requestContactDetailsEvent, Contact contact) {
        return adminContactPersistenceService.requestContactDetails(requestContactDetailsEvent, contact);
    }
}