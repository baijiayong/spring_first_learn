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

public class AdminContactControllerTest {
    MockMvc mockMvc;
    
    @InjectMocks
    AdminContactController controller;
    
    @Mock
    AdminContactService adminContactService;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = standaloneSetup(controller).build();
        when(adminContactService.allContactsList(any(RequestAllContactItemsEvent.class))).thenReturn(WebDataFixture.allContactList());     
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
        mockMvc.perform(get("/admin/contact/show"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(model().attributeExists("contact"))
            .andExpect(view().name(is("adminContactShow")));
    }
}