package com.baldurtech;

import com.baldurtech.contact.core.domain.Contact;
import com.baldurtech.contact.events.AllContactsListEvent;
import com.baldurtech.contact.events.RequestAllContactItemsEvent;
import com.baldurtech.contact.events.ContactDetailsEvent;
import com.baldurtech.contact.events.RequestContactDetailsEvent;

import java.util.List;
import java.util.ArrayList;

public class WebDataFixture {
    public static AllContactsListEvent allContactList() {
        Contact contact1 = new Contact();
        contact1.setName("Xiao Bai");
        contact1.setMobile("18234444444");
        contact1.setEmail("xiaobai@gmail.com");
        contact1.setVpmn("62222");
        
        Contact contact2 = new Contact();
        contact2.setName("Shi Hang");
        contact2.setMobile("18766666666");
        contact2.setEmail("shihang@gmail.com");
        contact2.setVpmn("63333");
        
        List<Contact> contacts = new ArrayList<Contact>();
        contacts.add(contact1);
        contacts.add(contact2);
        
        return new AllContactsListEvent(contacts);
    }
    
    public static ContactDetailsEvent contactDetails(Contact contact) {
        contact.setName("Xiaobai");
        contact.setMobile("18234444444");
        contact.setVpmn("64444");
        contact.setEmail("xiaobai@gmail.com");
       
        return new ContactDetailsEvent(contact);
    }
}