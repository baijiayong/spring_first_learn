package com.baldurtech.events;

import java.util.List;

import com.baldurtech.core.Contact;

public class AllContactsListEvent {
    public List<Contact> contacts;
    
    public AllContactsListEvent(List<Contact> contacts) {
        this.contacts = contacts;
    }
    
    public List<Contact> getContactList() {
        return contacts;
    }
}