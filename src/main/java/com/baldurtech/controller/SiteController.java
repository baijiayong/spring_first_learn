package com.baldurtech.controller;

import com.baldurtech.events.RequestAllContactItemsEvent;
import com.baldurtech.core.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class SiteController {
    @Autowired
    private ContactService contactService;
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    @ResponseBody
    public String getContactList() {
        return "foo!";
    }
}