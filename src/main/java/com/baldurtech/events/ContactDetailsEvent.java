package com.baldurtech.events;

import com.baldurtech.core.Contact;

import java.util.List;
import java.util.ArrayList;

public class ContactDetailsEvent {
    List<Contact> contacts = new ArrayList<Contact>();
    
    public ContactDetailsEvent(List<Contact> contacts) {
        this.contacts = contacts;
    }
    
    public List<Contact> getContactDetails() {
        return contacts;
    }
}