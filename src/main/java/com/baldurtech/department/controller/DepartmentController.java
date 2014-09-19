package com.baldurtech.department.controller;

import com.baldurtech.department.events.AllDepartmentItemsEvent;
import com.baldurtech.department.events.RequestAllDepartmentItemsEvent;
import com.baldurtech.department.events.RequestDepartmentDetailsEvent;
import com.baldurtech.department.events.DepartmentDetailsEvent;
import com.baldurtech.department.core.service.DepartmentService;
import com.baldurtech.department.core.service.DepartmentEventHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    
    @RequestMapping("/show")
    public String getDepartmentDetails(@RequestParam(value="id", required=false, defaultValue="") String id, Model model) {
        DepartmentDetailsEvent departmentDetailsEvent = departmentService.getDepartmentDetails(new RequestDepartmentDetailsEvent(), Long.valueOf(id));
        model.addAttribute("department", departmentDetailsEvent.getDepartmentDetails());
        return "departmentShow";
    }
}