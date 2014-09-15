package com.baldurtech.controller;

import com.baldurtech.controller.SimpleSiteController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

public class SimpleSiteIntegrationTest {
    MockMvc mockMvc;
    
    SimpleSiteController controller = new SimpleSiteController();
    
    @Before
    public void setup() {
        this.mockMvc = standaloneSetup(controller).build();
    }
    
    @Test
    public void thatTextReturned() throws Exception { 
        mockMvc.perform(get("/contact"))
            .andDo(print())
            .andExpect(content().string("Hi, Contact"));
    }
    
    @Test
    public void thatExceptedTextReturned() throws Exception {
        mockMvc.perform(get("/contact/list"))
            .andDo(print())
            .andExpect(content().string("ContactList"));
    }
}