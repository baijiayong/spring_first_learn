package com.baldurtech.core;

import java.util.List;

import com.baldurtech.core.Contact;
import com.baldurtech.events.RequestAllContactItemsEvent;
import com.baldurtech.persistence.ContactPersistenceService;

public class ContactEventHandler implements ContactService {

    private ContactPersistenceService contactPersistenceService;

    public ContactEventHandler(ContactPersistenceService contactPersistenceService) {
        this.contactPersistenceService = contactPersistenceService;
    }

    @Override
    public List<Contact> allContactList(RequestAllContactItemsEvent requestAllContactItemsEvent) {
        return contactPersistenceService.requestAllContactItems(requestAllContactItemsEvent);
    }
}