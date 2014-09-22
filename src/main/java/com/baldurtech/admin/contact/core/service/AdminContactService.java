package com.baldurtech.admin.contact.core.service;

import com.baldurtech.contact.events.RequestAllContactItemsEvent;
import com.baldurtech.contact.events.AllContactsListEvent;

public interface AdminContactService {
    public AllContactsListEvent allContactsList(RequestAllContactItemsEvent requestAllContactItemsEvent);
}