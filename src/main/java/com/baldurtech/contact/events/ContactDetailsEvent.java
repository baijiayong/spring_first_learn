package com.baldurtech.contact.events;

import com.baldurtech.contact.core.domain.Contact;

import java.util.List;
import java.util.ArrayList;

public class ContactDetailsEvent {
    Contact contact = new Contact();
    
    public ContactDetailsEvent(Contact contact) {
        this.contact = contact;
    }
    
    public Contact getContactDetails() {
        return contact;
    }
}