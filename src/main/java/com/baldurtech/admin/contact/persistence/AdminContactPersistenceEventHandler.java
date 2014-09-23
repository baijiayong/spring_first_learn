package com.baldurtech.admin.contact.persistence;

import com.baldurtech.contact.events.RequestAllContactItemsEvent;
import com.baldurtech.contact.events.AllContactsListEvent;
import com.baldurtech.contact.events.RequestContactDetailsEvent;
import com.baldurtech.contact.events.ContactDetailsEvent;
import com.baldurtech.contact.events.CreateContactDetailsEvent;
import com.baldurtech.admin.contact.repository.AdminContactRepository;
import com.baldurtech.contact.core.domain.Contact;

public class AdminContactPersistenceEventHandler implements AdminContactPersistenceService {
    AdminContactRepository adminContactRepository;
    
    public AdminContactPersistenceEventHandler (AdminContactRepository adminContactRepository) {
        this.adminContactRepository = adminContactRepository;
    }
    
    @Override
    public AllContactsListEvent requestAllContactsList(RequestAllContactItemsEvent requestAllContactItemsEvent) {
        return new AllContactsListEvent(adminContactRepository.findAllContacts());
    } 
    
    @Override
    public ContactDetailsEvent requestContactDetails(RequestContactDetailsEvent requestContactDetailsEvent, Contact contact) {
        return new ContactDetailsEvent(adminContactRepository.getById(contact));
    }
    
    @Override
    public CreateContactDetailsEvent createContact(CreateContactDetailsEvent createContactDetailsEvent) {
        return new CreateContactDetailsEvent(adminContactRepository.create(createContactDetailsEvent.getContactDetails()));
    }
}