package com.baldurtech.contact.events;

import com.baldurtech.contact.core.domain.Contact;

public class DeletedContactEvent {
    Contact contact;
    public DeletedContactEvent(Contact contact) {
        this.contact = contact;
    }
    public Contact deletedContact() {
        return contact;
    }
}