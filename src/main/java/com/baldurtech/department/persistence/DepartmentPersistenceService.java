package com.baldurtech.department.persistence;

import com.baldurtech.department.events.AllDepartmentItemsEvent;
import com.baldurtech.department.events.RequestAllDepartmentItemsEvent;
import com.baldurtech.department.events.DepartmentDetailsEvent;
import com.baldurtech.department.events.RequestDepartmentDetailsEvent;
import com.baldurtech.department.core.domain.Department;

public interface DepartmentPersistenceService {
    public AllDepartmentItemsEvent requestAllDepartmentItems(RequestAllDepartmentItemsEvent requestAllDepartmentItemsEvent);
    public DepartmentDetailsEvent requestDepartmentDetails(RequestDepartmentDetailsEvent requestDepartmentDetailsEvent, Department department);
}