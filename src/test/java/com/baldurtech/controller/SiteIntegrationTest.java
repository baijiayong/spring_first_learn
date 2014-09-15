package com.baldurtech.controller;

import com.baldurtech.core.ContactService;
import com.baldurtech.events.RequestAllContactItemsEvent;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class SiteIntegrationTest {
    MockMvc mockMvc;
    
    @InjectMocks
    SiteController controller;
    
    @Mock
    ContactService contactService;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = standaloneSetup(controller).build();
        when(contactService.allContactList(any(RequestAllContactItemsEvent.class))).thenReturn(WebDataFixture.allContactList());
        
    }
    
    @Test
    public void thatTextReturned() throws Exception {
        mockMvc.perform(get("/"))
            .andDo(print())
            .andExpect(content().string("foo!"));
    }
}