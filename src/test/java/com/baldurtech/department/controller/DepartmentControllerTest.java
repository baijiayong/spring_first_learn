package com.baldurtech.department.controller;

import com.baldurtech.department.events.AllDepartmentItemsEvent;
import com.baldurtech.department.events.RequestAllDepartmentItemsEvent;
import com.baldurtech.department.core.service.DepartmentService;
import com.baldurtech.department.core.service.DepartmentEventHandler;
import com.baldurtech.department.events.RequestDepartmentDetailsEvent;
import com.baldurtech.department.events.DepartmentDetailsEvent;
import com.baldurtech.department.core.domain.Department;
import com.baldurtech.WebDataFixture;

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

public class DepartmentControllerTest {
    MockMvc mockMvc;
    
    @InjectMocks
    DepartmentController controller;
    
    @Mock
    DepartmentService departmentService;
    
    Department department = WebDataFixture.createDepartment();
    @Before
    public void setup() {
        department.setId(1L);
        MockitoAnnotations.initMocks(this);
        
        mockMvc = standaloneSetup(controller).build();
        when(departmentService.allDepartmentList(any(RequestAllDepartmentItemsEvent.class))).thenReturn(WebDataFixture.allDepartmentsList());
        when(departmentService.getDepartmentDetails(any(RequestDepartmentDetailsEvent.class), any(Department.class))).thenReturn(WebDataFixture.departmentDetails(department));
    }
    
    @Test
    public void thatViewdepartmentlist() throws Exception {
        mockMvc.perform(get("/department/list"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(model().attributeExists("departmentList"))
            .andExpect(view().name("departmentList"));
    }   

    @Test 
    public void thatViewDepartmentShow() throws Exception {
        mockMvc.perform(get("/department/show").param("id", String.valueOf(department.getId())))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(model().attributeExists("department"))
            .andExpect(view().name("departmentShow"));
    }
}