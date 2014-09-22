package com.baldurtech.admin.contact.controller;

import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;

import com.baldurtech.WebDataFixture;
import com.baldurtech.admin.contact.core.service.AdminContactService;
import com.baldurtech.contact.events.RequestAllContactItemsEvent;
import com.baldurtech.contact.events.RequestContactDetailsEvent;
import com.baldurtech.contact.core.domain.Contact;

public class AdminContactControllerTest {
    MockMvc mockMvc;
    
    @InjectMocks
    AdminContactController controller;
    
    @Mock
    AdminContactService adminContactService;
    
    Contact contact = new Contact();
    
    @Before
    public void setup() {
        
        contact.setId(1L);
        
        MockitoAnnotations.initMocks(this);
        mockMvc = standaloneSetup(controller).build();
        when(adminContactService.allContactsList(any(RequestAllContactItemsEvent.class))).thenReturn(WebDataFixture.allContactList()); 
        when(adminContactService.contactDetails(any(RequestContactDetailsEvent.class), any(Contact.class))).thenReturn(WebDataFixture.contactDetails(contact));
    }
    
    @Test
    public void thatViewList() throws Exception {
        mockMvc.perform(get("/admin/contact/list"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(model().attributeExists("contactList"))
            .andExpect(view().name(is("adminContactList")));
    }
    
    @Test 
    public void thatViewShow() throws Exception {
        mockMvc.perform(get("/admin/contact/show").param("id",String.valueOf(contact.getId())))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(model().attributeExists("contact"))
            .andExpect(view().name(is("adminContactShow")));
    }
    
   
}
