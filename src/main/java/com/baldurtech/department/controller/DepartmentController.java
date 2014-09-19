package com.baldurtech.department.controller;

import com.baldurtech.department.events.AllDepartmentItemsEvent;
import com.baldurtech.department.events.RequestAllDepartmentItemsEvent;
import com.baldurtech.department.core.service.DepartmentService;
import com.baldurtech.department.core.service.DepartmentEventHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    
    @RequestMapping("/list")
    public String getDepartmentList(Model model) {
        AllDepartmentItemsEvent allDepartmentItems = departmentService.allDepartmentList(new RequestAllDepartmentItemsEvent());
        model.addAttribute("departmentList", allDepartmentItems.getAllDepartmentItems());
        return "departmentList";
    }
}