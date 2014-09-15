package com.baldurtech.core;

import com.baldurtech.events.RequestAllContactItemsEvent;

import java.util.List;

public interface ContactService {
    public List<Contact> allContactList(RequestAllContactItemsEvent requestAllContactItemsEvent);
}