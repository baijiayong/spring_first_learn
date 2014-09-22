package com.baldurtech.contact.persistence;

import java.util.List;

import com.baldurtech.contact.core.domain.Contact;
import com.baldurtech.contact.events.RequestAllContactItemsEvent;
import com.baldurtech.contact.events.RequestContactDetailsEvent;
import com.baldurtech.contact.events.ContactDetailsEvent;
import com.baldurtech.contact.events.AllContactsListEvent;

public interface ContactPersistenceService {
    public AllContactsListEvent requestAllContactItems(RequestAllContactItemsEvent requestAllContactItemsEvent);
    public ContactDetailsEvent requestContactDetails(RequestContactDetailsEvent requestContactDetailsEvent, Contact contact);
}