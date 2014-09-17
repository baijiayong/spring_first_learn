package com.baldurtech.repository;

import java.util.List;
import java.util.ArrayList;

import com.baldurtech.core.Contact;

public class ContactMemoryRepository implements ContactRepository {
 
    @Override
    public List<Contact> findAllContact() {
        List<Contact> contacts = new ArrayList<Contact>();
        Contact contact1 = new Contact();
        contact1.setName("Xiao Bai");
        contact1.setMobile("18233333333");
        contact1.setVpmn("63333");
        contact1.setEmail("xiaobai@gmail.com");
        
        Contact contact2 = new Contact();
        contact2.setName("Shi Hang");
        contact2.setMobile("18711111111");
        contact2.setVpmn("65555");
        contact2.setEmail("shihang@gmail.com");
        
        contacts.add(contact1);
        contacts.add(contact2);
       
        return contacts;
    }
    
    @Override
    public Contact getById(Long id) {
        Contact contact = new Contact();
        contact.setId(id);
        contact.setName("Xu Shuangshuang");
        contact.setMobile("18766666666");
        contact.setVpmn("69999");
        contact.setEmail("Xu@gmail.com");
        
        return contact;
    }
}