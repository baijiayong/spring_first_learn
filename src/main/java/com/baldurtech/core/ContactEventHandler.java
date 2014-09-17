package com.baldurtech.core;

import java.util.List;

import com.baldurtech.core.Contact;
import com.baldurtech.events.AllContactsListEvent;
import com.baldurtech.events.RequestAllContactItemsEvent;
import com.baldurtech.events.ContactDetailsEvent;
import com.baldurtech.events.RequestContactDetailsEvent;
import com.baldurtech.persistence.ContactPersistenceService;

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