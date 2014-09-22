package com.baldurtech.admin.contact.persistence;

import com.baldurtech.contact.events.RequestAllContactItemsEvent;
import com.baldurtech.contact.events.AllContactsListEvent;
import com.baldurtech.admin.contact.repository.AdminContactRepository;

public class AdminContactPersistenceEventHandler implements AdminContactPersistenceService {
    AdminContactRepository adminContactRepository;
    
    public AdminContactPersistenceEventHandler (AdminContactRepository adminContactRepository) {
        this.adminContactRepository = adminContactRepository;
    }
    
    @Override
    public AllContactsListEvent requestAllContactsList(RequestAllContactItemsEvent requestAllContactItemsEvent) {
        return new AllContactsListEvent(adminContactRepository.findAllContacts());
    } 
}