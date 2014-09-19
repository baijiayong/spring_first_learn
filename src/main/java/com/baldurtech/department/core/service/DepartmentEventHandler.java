package com.baldurtech.department.core.service;

import com.baldurtech.department.events.RequestAllDepartmentItemsEvent;
import com.baldurtech.department.events.AllDepartmentItemsEvent;
import com.baldurtech.department.persistence.DepartmentPersistenceService;
import com.baldurtech.department.events.DepartmentDetailsEvent;
import com.baldurtech.department.events.RequestDepartmentDetailsEvent;
import com.baldurtech.department.core.domain.Department;

public class DepartmentEventHandler implements DepartmentService {
    private DepartmentPersistenceService departmentPersistenceService;
    
    public DepartmentEventHandler (DepartmentPersistenceService departmentPersistenceService) {
        this.departmentPersistenceService = departmentPersistenceService;
    }
    
    @Override
    public AllDepartmentItemsEvent allDepartmentList(RequestAllDepartmentItemsEvent requestAllDepartmentItemsEvent) {
        return departmentPersistenceService.requestAllDepartmentItems(requestAllDepartmentItemsEvent);
    }
    
    @Override
    public DepartmentDetailsEvent getDepartmentDetails(RequestDepartmentDetailsEvent requestDepartmentDetailsEvent,Department department) {
        return departmentPersistenceService.requestDepartmentDetails(requestDepartmentDetailsEvent, department);
    }
}