package com.baldurtech.core;

import com.baldurtech.events.RequestAllContactItemsEvent;
import com.baldurtech.events.RequestContactDetailsEvent;
import com.baldurtech.events.ContactDetailsEvent;
import com.baldurtech.events.AllContactsListEvent;

import java.util.List;

public interface ContactService {
    public AllContactsListEvent allContactList(RequestAllContactItemsEvent requestAllContactItemsEvent);
    public ContactDetailsEvent getContact(RequestContactDetailsEvent requestContactDetailsEvent, Long id);
}