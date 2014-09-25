package com.baldurtech.admin.contact.core.service;

import com.baldurtech.contact.events.RequestAllContactItemsEvent;
import com.baldurtech.contact.events.AllContactsListEvent;
import com.baldurtech.contact.events.RequestContactDetailsEvent;
import com.baldurtech.contact.events.ContactDetailsEvent;
import com.baldurtech.contact.core.domain.Contact;
import com.baldurtech.contact.events.CreateContactDetailsEvent;
import com.baldurtech.contact.events.DeletedContactEvent;
import com.baldurtech.contact.events.DeleteContactEvent;

public interface AdminContactService {
    public AllContactsListEvent allContactsList(RequestAllContactItemsEvent requestAllContactItemsEvent);
    public ContactDetailsEvent contactDetails(RequestContactDetailsEvent requestContactDetailsEvent, Contact contact);
    public CreateContactDetailsEvent createContact(CreateContactDetailsEvent createContactDetailsEvent);
    public DeletedContactEvent deleteContact(DeleteContactEvent deleteContactEvent, Contact contact);
    public CreateContactDetailsEvent updateContact(CreateContactDetailsEvent createContactDetailsEvent, Contact contact);
}