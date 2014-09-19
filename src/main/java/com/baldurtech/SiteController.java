package com.baldurtech;

import com.baldurtech.contact.events.RequestAllContactItemsEvent;
import com.baldurtech.contact.events.AllContactsListEvent;
import com.baldurtech.contact.core.service.ContactService;
import com.baldurtech.contact.core.domain.Contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/")
public class SiteController {
    @Autowired
    private ContactService contactService;
    
    @RequestMapping(method=RequestMethod.GET)
    public String getContactList(Model model) {
        AllContactsListEvent allContactList = contactService.allContactList(new RequestAllContactItemsEvent());
        model.addAttribute("contactList", allContactList.getContactList());
        return "list";
    }
}