package com.baldurtech.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/contact")
public class SimpleSiteController {
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> getCurrentList() {
        return new ResponseEntity<String> ("Hi, Contact", HttpStatus.FOUND);
    }
    
    @RequestMapping(value="/list", method=RequestMethod.GET)
    @ResponseBody
    public String contactList() {
        return "ContactList";
    }
}

