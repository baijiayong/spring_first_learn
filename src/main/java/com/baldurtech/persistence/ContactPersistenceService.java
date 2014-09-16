package com.baldurtech.persistence;

import java.util.List;

import com.baldurtech.core.Contact;
import com.baldurtech.events.RequestAllContactItemsEvent;
import com.baldurtech.events.AllContactsListEvent;

public interface ContactPersistenceService {
    public AllContactsListEvent requestAllContactItems(RequestAllContactItemsEvent requestAllContactItemsEvent);
}