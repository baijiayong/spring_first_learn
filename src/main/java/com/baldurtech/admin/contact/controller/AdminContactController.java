package com.baldurtech.admin.contact.controller;

import com.baldurtech.contact.events.RequestContactDetailsEvent;
import com.baldurtech.contact.events.RequestAllContactItemsEvent;
import com.baldurtech.contact.events.AllContactsListEvent;
import com.baldurtech.contact.events.ContactDetailsEvent;
import com.baldurtech.contact.events.DeleteContactEvent;
import com.baldurtech.admin.contact.core.service.AdminContactService;
import com.baldurtech.contact.core.domain.Contact;
import com.baldurtech.contact.events.CreateContactDetailsEvent;

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
        AllContactsListEvent contactsList = adminContactService.allContactsList(new RequestAllContactItemsEvent());
        model.addAttribute("contactList", contactsList.getContactList());
        return "adminContactList";
    }
    
    @RequestMapping(value="/show", method=RequestMethod.GET)
    public String getContactShow(@RequestParam(value="id", required=false, defaultValue="") String id, Model model) {
        Contact contact = new Contact();
        contact.setId(Long.valueOf(id));
        
        ContactDetailsEvent contactDetails = adminContactService.contactDetails(new RequestContactDetailsEvent(), contact);
        model.addAttribute("contact", contactDetails.getContactDetails());
        
        return "adminContactShow";
    }
    
    @RequestMapping(value="/create", method=RequestMethod.GET)
    public String createContact() {
        return "createContact";
    }
    
    @RequestMapping(value="/list", method=RequestMethod.POST)
    public String createContact(@RequestParam(value="name", required=false, defaultValue="") String name
        ,@RequestParam(value="mobile", required=false, defaultValue="") String mobile
        ,@RequestParam(value="vpmn", required=false, defaultValue="") String vpmn
        ,@RequestParam(value="email", required=false, defaultValue="") String email
        ,@RequestParam(value="homeAddress", required=false, defaultValue="") String homeAddress
        ,@RequestParam(value="officeAddress", required=false, defaultValue="") String officeAddress
        ,@RequestParam(value="job", required=false, defaultValue="") String job
        ,@RequestParam(value="jobLevel", required=false, defaultValue="") String jobLevel
        ,@RequestParam(value="memo", required=false, defaultValue="") String memo
        ,Model model) {
        
        Contact contact = new Contact();
        contact.setName(name);
        contact.setMobile(mobile);
        contact.setVpmn(vpmn);
        contact.setEmail(email);
        contact.setHomeAddress(homeAddress);
        contact.setOfficeAddress(officeAddress);
        contact.setJob(job);
        contact.setJobLevel(Long.valueOf(jobLevel));
        contact.setMemo(memo);
        
        adminContactService.createContact(new CreateContactDetailsEvent(contact));
        
        return "redirect:list";
    }
    
    @RequestMapping(value="/show",method=RequestMethod.POST)
    public String deleteContact(@RequestParam(value="id", required=false, defaultValue="") String id
        ,@RequestParam(value="action", required=false, defaultValue="") String action
        ,@RequestParam(value="name", required=false, defaultValue="") String name
        ,@RequestParam(value="mobile", required=false, defaultValue="") String mobile
        ,@RequestParam(value="vpmn", required=false, defaultValue="") String vpmn
        ,@RequestParam(value="email", required=false, defaultValue="") String email
        ,@RequestParam(value="homeAddress", required=false, defaultValue="") String homeAddress
        ,@RequestParam(value="officeAddress", required=false, defaultValue="") String officeAddress
        ,@RequestParam(value="job", required=false, defaultValue="") String job
        ,@RequestParam(value="jobLevel", required=false, defaultValue="") String jobLevel
        ,@RequestParam(value="memo", required=false, defaultValue="") String memo) {
        
        Contact contact = new Contact();
        contact.setId(Long.valueOf(id));
        
        Contact updateContact  = new Contact();
        updateContact.setName(name);
        updateContact.setMobile(mobile);
        updateContact.setVpmn(vpmn);
        updateContact.setEmail(email);
        updateContact.setHomeAddress(homeAddress);
        updateContact.setOfficeAddress(officeAddress);
        updateContact.setJob(job);
        updateContact.setJobLevel(Long.valueOf(jobLevel));
        updateContact.setMemo(memo);
        
        if(action.equals("delete")) {
            adminContactService.deleteContact(new DeleteContactEvent(), contact);
        }else if(action.equals("update")) {
            adminContactService.updateContact(new CreateContactDetailsEvent(updateContact), contact);
        }
        
        return "redirect:list";
    }
}