package com.baldurtech.department.core.service;

import com.baldurtech.department.events.RequestAllDepartmentItemsEvent;
import com.baldurtech.department.events.AllDepartmentItemsEvent;
import com.baldurtech.department.persistence.DepartmentPersistenceService;

public class DepartmentEventHandler implements DepartmentService {
    private DepartmentPersistenceService departmentPersistenceService;
    
    public DepartmentEventHandler (DepartmentPersistenceService departmentPersistenceService) {
        this.departmentPersistenceService = departmentPersistenceService;
    }
    
    @Override
    public AllDepartmentItemsEvent allDepartmentList(RequestAllDepartmentItemsEvent requestAllDepartmentItemsEvent) {
        return departmentPersistenceService.requestAllDepartmentItems(requestAllDepartmentItemsEvent);
    }
}