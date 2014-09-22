package com.baldurtech.admin.contact.core.service;

import com.baldurtech.contact.events.RequestAllContactItemsEvent;
import com.baldurtech.contact.events.AllContactsListEvent;
import com.baldurtech.contact.events.RequestContactDetailsEvent;
import com.baldurtech.contact.events.ContactDetailsEvent;
import com.baldurtech.contact.core.domain.Contact;

public interface AdminContactService {
    public AllContactsListEvent allContactsList(RequestAllContactItemsEvent requestAllContactItemsEvent);
    public ContactDetailsEvent contactDetails(RequestContactDetailsEvent requestContactDetailsEvent, Contact contact);
}