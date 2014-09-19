package com.baldurtech.contact.events;

import java.util.List;

import com.baldurtech.contact.core.domain.Contact;

public class AllContactsListEvent {
    public List<Contact> contacts;
    
    public AllContactsListEvent(List<Contact> contacts) {
        this.contacts = contacts;
    }
    
    public List<Contact> getContactList() {
        return contacts;
    }
}