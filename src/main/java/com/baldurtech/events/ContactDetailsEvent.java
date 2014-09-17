package com.baldurtech.events;

import com.baldurtech.core.Contact;

public class ContactDetailsEvent {
    Contact contact = new Contact();
    
    public ContactDetailsEvent(Contact contact) {
        this.contact = contact;
    }
    
    public Contact getContactDetails() {
        return contact;
    }
}