package com.baldurtech.controller;

import com.baldurtech.events.RequestContactDetailsEvent;
import com.baldurtech.events.RequestAllContactItemsEvent;
import com.baldurtech.events.AllContactsListEvent;
import com.baldurtech.events.ContactDetailsEvent;
import com.baldurtech.core.ContactService;
import com.baldurtech.core.Contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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