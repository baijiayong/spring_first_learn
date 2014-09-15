package com.baldurtech.events;

import com.baldurtech.core.Contact;
import java.util.List;

public class RequestAllContactItemsEvent extends ReadEvent{
    private List<Contact> contacts;

    public RequestAllContactItemsEvent(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<Contact> getAllContacts() {
        return contacts;
    }
}