package com.baldurtech.contact.core.service;

import java.util.List;

import com.baldurtech.contact.core.domain.Contact;
import com.baldurtech.contact.events.AllContactsListEvent;
import com.baldurtech.contact.events.RequestAllContactItemsEvent;
import com.baldurtech.contact.events.ContactDetailsEvent;
import com.baldurtech.contact.events.RequestContactDetailsEvent;
import com.baldurtech.contact.persistence.ContactPersistenceService;

public class ContactEventHandler implements ContactService {

    private ContactPersistenceService contactPersistenceService;

    public ContactEventHandler(ContactPersistenceService contactPersistenceService) {
        this.contactPersistenceService = contactPersistenceService;
    }

    @Override
    public AllContactsListEvent allContactList(RequestAllContactItemsEvent requestAllContactItemsEvent) {
        return contactPersistenceService.requestAllContactItems(requestAllContactItemsEvent);
    }
    
    @Override
    public ContactDetailsEvent getContact(RequestContactDetailsEvent requestContactDetailsEvent, Long id) {
        return contactPersistenceService.requestContactDetails(requestContactDetailsEvent, id);
    }
}