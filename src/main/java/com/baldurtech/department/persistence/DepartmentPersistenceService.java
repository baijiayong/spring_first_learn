package com.baldurtech.department.persistence;

import com.baldurtech.department.events.AllDepartmentItemsEvent;
import com.baldurtech.department.events.RequestAllDepartmentItemsEvent;
import com.baldurtech.department.events.DepartmentDetailsEvent;
import com.baldurtech.department.events.RequestDepartmentDetailsEvent;

public interface DepartmentPersistenceService {
    public AllDepartmentItemsEvent requestAllDepartmentItems(RequestAllDepartmentItemsEvent requestAllDepartmentItemsEvent);
    public DepartmentDetailsEvent requestDepartmentDetails(RequestDepartmentDetailsEvent requestDepartmentDetailsEvent, Long id);
}