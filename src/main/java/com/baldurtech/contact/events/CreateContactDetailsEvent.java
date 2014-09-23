package com.baldurtech.contact.events;

import com.baldurtech.contact.core.domain.Contact;

public class CreateContactDetailsEvent {
    Contact contact;
    public CreateContactDetailsEvent(Contact contact) {
        this.contact = contact;
    }
    
    public Contact getContactDetails() {
        return contact;
    } 
}