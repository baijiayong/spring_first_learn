package com.baldurtech.admin.contact.controller;

import com.baldurtech.contact.events.RequestContactDetailsEvent;
import com.baldurtech.contact.events.RequestAllContactItemsEvent;
import com.baldurtech.contact.events.AllContactsListEvent;
import com.baldurtech.contact.events.ContactDetailsEvent;
import com.baldurtech.admin.contact.core.service.AdminContactService;
import com.baldurtech.contact.core.domain.Contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin/contact")
public class AdminContactController {
    @Autowired
    private AdminContactService adminContactService;
    
    @RequestMapping(value="/list", method=RequestMethod.GET)
    public String getContactList(Model model) {
        AllContactsListEvent ContactsList = adminContactService.allContactsList(new RequestAllContactItemsEvent());
        model.addAttribute("contactList", ContactsList.getContactList());
        return "list";
    }
}