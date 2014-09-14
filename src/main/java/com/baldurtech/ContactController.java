package com.baldurtech; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContactController {
    final private ContactService contactService;
    
    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }
    
    public void printMessage() {
        System.out.println(this.contactService.getMessage());
    }
}
