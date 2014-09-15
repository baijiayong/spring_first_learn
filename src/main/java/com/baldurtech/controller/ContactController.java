package com.baldurtech.controller; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.baldurtech.core.ContactService;

@Component
public class ContactController {
    final private ContactService contactService;
    
    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }
}
