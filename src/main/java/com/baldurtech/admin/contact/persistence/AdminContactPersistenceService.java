package com.baldurtech.admin.contact.persistence;

import com.baldurtech.contact.events.RequestAllContactItemsEvent;
import com.baldurtech.contact.events.AllContactsListEvent;
import com.baldurtech.contact.events.RequestContactDetailsEvent;
import com.baldurtech.contact.events.ContactDetailsEvent;
import com.baldurtech.contact.core.domain.Contact;

public interface AdminContactPersistenceService {
    public AllContactsListEvent requestAllContactsList(RequestAllContactItemsEvent requestAllContactItemsEvent);
    public ContactDetailsEvent requestContactDetails(RequestContactDetailsEvent requestContactDetailsEvent, Contact contact);
}