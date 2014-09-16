package com.baldurtech.persistence;

import java.util.List;

import com.baldurtech.core.Contact;
import com.baldurtech.repository.ContactRepository;
import com.baldurtech.events.AllContactsListEvent;
import com.baldurtech.events.RequestAllContactItemsEvent;

public class ContactPersistenceEventHandler implements ContactPersistenceService {
    private ContactRepository contactRepository;

    public ContactPersistenceEventHandler(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override                  
    public AllContactsListEvent requestAllContactItems(RequestAllContactItemsEvent requestAllContactItemsEvent) {
        List<Contact> contacts = contactRepository.findAllContact();
        return new AllContactsListEvent(contacts);
    }
}