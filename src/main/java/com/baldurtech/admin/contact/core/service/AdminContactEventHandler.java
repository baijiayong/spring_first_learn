package com.baldurtech.admin.contact.core.service;

import com.baldurtech.contact.events.RequestAllContactItemsEvent;
import com.baldurtech.contact.events.AllContactsListEvent;
import com.baldurtech.admin.contact.persistence.AdminContactPersistenceService;

public class AdminContactEventHandler implements AdminContactService {
    AdminContactPersistenceService adminContactPersistenceService;
    
    public AdminContactEventHandler (AdminContactPersistenceService adminContactPersistenceService) {
        this.adminContactPersistenceService = adminContactPersistenceService;
    }
    
    @Override
    public AllContactsListEvent allContactsList(RequestAllContactItemsEvent requestAllContactItemsEvent) {
        return adminContactPersistenceService.requestAllContactsList(requestAllContactItemsEvent);
    }
}