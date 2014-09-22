package com.baldurtech.admin.contact.persistence;

import com.baldurtech.contact.events.RequestAllContactItemsEvent;
import com.baldurtech.contact.events.AllContactsListEvent;

public interface AdminContactPersistenceService {
    public AllContactsListEvent requestAllContactsList(RequestAllContactItemsEvent requestAllContactItemsEvent);
}