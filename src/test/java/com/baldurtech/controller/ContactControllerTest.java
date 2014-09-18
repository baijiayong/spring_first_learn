package com.baldurtech.controller;

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

import com.baldurtech.core.ContactService;
import com.baldurtech.events.RequestAllContactItemsEvent;

public class ContactControllerTest {
    MockMvc mockMvc;
    
    @InjectMocks
    ContactController controller;
    
    @Mock
    ContactService contactService;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = standaloneSetup(controller).build();
        when(contactService.allContactList(any(RequestAllContactItemsEvent.class))).thenReturn(WebDataFixture.allContactList());
    }
    
    @Test
    public void thatViewList() throws Exception {
        mockMvc.perform(get("/contact/list"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(model().attributeExists("contactList"))
            .andExpect(view().name(is("show")));
    }
    
    @Test
    public void thatViewShow() throws Exception {
        mockMvc.perform(get("/contact/show"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(model().attributeExists("contact"))
            .andExpect(view().name(is("show")));
    }
}