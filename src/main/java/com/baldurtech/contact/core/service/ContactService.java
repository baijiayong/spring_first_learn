package com.baldurtech.contact.core.service;

import com.baldurtech.contact.events.RequestAllContactItemsEvent;
import com.baldurtech.contact.events.RequestContactDetailsEvent;
import com.baldurtech.contact.events.ContactDetailsEvent;
import com.baldurtech.contact.events.AllContactsListEvent;

import java.util.List;

public interface ContactService {
    public AllContactsListEvent allContactList(RequestAllContactItemsEvent requestAllContactItemsEvent);
    public ContactDetailsEvent getContact(RequestContactDetailsEvent requestContactDetailsEvent, Long id);
}