package com.baldurtech.contact.controller;

import com.baldurtech.contact.events.RequestContactDetailsEvent;
import com.baldurtech.contact.events.RequestAllContactItemsEvent;
import com.baldurtech.contact.events.AllContactsListEvent;
import com.baldurtech.contact.events.ContactDetailsEvent;
import com.baldurtech.contact.core.service.ContactService;
import com.baldurtech.contact.core.domain.Contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    private ContactService contactService;
    
    @RequestMapping(value="/list", method=RequestMethod.GET)
    public String getContactList(Model model) {
        AllContactsListEvent allContactList = contactService.allContactList(new RequestAllContactItemsEvent());
        model.addAttribute("contactList", allContactList.getContactList());
        return "list";
    }
    
    @RequestMapping(value="/show", method=RequestMethod.GET)
    public String getContactShow(@RequestParam(value="id", required=false, defaultValue="") String id, Model model) {
        ContactDetailsEvent contactDetail = contactService.getContact(new RequestContactDetailsEvent(), Long.valueOf(id));
        model.addAttribute("contact", contactDetail.getContactDetails());
        return "show";
    }
}