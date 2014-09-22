package com.baldurtech.admin.contact.repository;

import com.baldurtech.contact.core.domain.Contact;

import java.util.List;
import java.util.ArrayList;

public class AdminContactMemoryRepository implements AdminContactRepository {

    @Override
    public List<Contact> findAllContacts() {
        List<Contact> contacts = new ArrayList<Contact>();
        
        Contact contact1 = new Contact();
        contact1.setName("Xiaobai");
        contact1.setMobile("18233333333");
        contact1.setVpmn("65555");
        contact1.setEmail("xiaobai@gmail.com");
        Contact contact2 = new Contact();
        contact2.setName("Zhang Mutou");
        contact2.setMobile("18244444444");
        contact2.setVpmn("63333");
        contact2.setEmail("mutou@gmail.com");
        
        contacts.add(contact1);
        contacts.add(contact2);
        
        return contacts;
    }
    
    @Override
    public Contact getById(Contact contact) {
        contact.setName("XuShuang");
        contact.setMobile("18236666666");
        contact.setVpmn("66666");
        contact.setEmail("shuang@gmail.com");
        
        return contact;
    }
}
