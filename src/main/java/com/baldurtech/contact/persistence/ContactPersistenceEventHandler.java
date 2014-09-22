package com.baldurtech.contact.persistence;

import java.util.List;

import com.baldurtech.contact.core.domain.Contact;
import com.baldurtech.contact.repository.ContactRepository;
import com.baldurtech.contact.events.AllContactsListEvent;
import com.baldurtech.contact.events.ContactDetailsEvent;
import com.baldurtech.contact.events.RequestContactDetailsEvent;
import com.baldurtech.contact.events.RequestAllContactItemsEvent;

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
    
    @Override
    public ContactDetailsEvent requestContactDetails(RequestContactDetailsEvent requestContactDetailsEvent, Contact contact) {
        return new ContactDetailsEvent(contactRepository.getById(contact));
    }
}