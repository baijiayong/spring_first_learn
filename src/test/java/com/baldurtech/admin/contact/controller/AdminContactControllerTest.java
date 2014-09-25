package com.baldurtech.admin.contact.controller;

import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;

import com.baldurtech.WebDataFixture;
import com.baldurtech.admin.contact.core.service.AdminContactService;
import com.baldurtech.contact.events.RequestAllContactItemsEvent;
import com.baldurtech.contact.events.RequestContactDetailsEvent;
import com.baldurtech.contact.events.CreateContactDetailsEvent;
import com.baldurtech.contact.events.DeleteContactEvent;
import com.baldurtech.contact.events.DeletedContactEvent;
import com.baldurtech.contact.core.domain.Contact;

public class AdminContactControllerTest {
    MockMvc mockMvc;
    
    @InjectMocks
    AdminContactController controller;
    
    @Mock
    AdminContactService adminContactService;
    
    Contact contact = WebDataFixture.createContact();
    
    @Before
    public void setup() {
        
        contact.setId(1L);
        
        MockitoAnnotations.initMocks(this);
        mockMvc = standaloneSetup(controller).build();
        when(adminContactService.allContactsList(any(RequestAllContactItemsEvent.class))).thenReturn(WebDataFixture.allContactList()); 
        when(adminContactService.contactDetails(any(RequestContactDetailsEvent.class), any(Contact.class))).thenReturn(WebDataFixture.contactDetails(contact));
        when(adminContactService.createContact(any(CreateContactDetailsEvent.class))).thenReturn(new CreateContactDetailsEvent(WebDataFixture.createContact()));
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
    
    @Test
    public void thatViewCreate() throws Exception {
        mockMvc.perform(get("/admin/contact/create"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("createContact"));
    }
    
    @Test
    public void thatCreateWillRedirectedToList() throws Exception {
        mockMvc.perform(post("/admin/contact/list"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name(is("adminContactList")))
            .andExpect(redirectedUrl("list"));
    }
    
    @Test
    public void thatWillCreateAContact() throws Exception {
        mockMvc.perform(post("/admin/contact/list")
            .param("name",String.valueOf(contact.getName()))
            .param("mobile", String.valueOf(contact.getMobile()))
            .param("vpmn", String.valueOf(contact.getVpmn()))
            .param("email", String.valueOf(contact.getEmail()))
            .param("homeAddress", String.valueOf(contact.getHomeAddress()))
            .param("officeAddress", String.valueOf(contact.getOfficeAddress()))
            .param("job", String.valueOf(contact.getJob()))
            .param("jobLevel", String.valueOf(contact.getJobLevel()))
            .param("memo", String.valueOf(contact.getMemo())))
            .andDo(print());
           
        verify(adminContactService).createContact(any(CreateContactDetailsEvent.class));
    }
    
    @Test
    public void thatDeleteWillRedirectedToList() throws Exception {
        mockMvc.perform(post("/admin/contact/show")
            .param("id", String.valueOf(contact.getId()))
            .param("action", String.valueOf("Delete")))
            .andDo(print())
            .andExpect(redirectedUrl("list"));
           
        verify(adminContactService).deleteContact(any(DeleteContactEvent.class), contact);
    }
}   
