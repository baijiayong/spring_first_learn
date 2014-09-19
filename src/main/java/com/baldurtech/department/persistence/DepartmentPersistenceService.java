package com.baldurtech.department.persistence;

import com.baldurtech.department.events.AllDepartmentItemsEvent;
import com.baldurtech.department.events.RequestAllDepartmentItemsEvent;

public interface DepartmentPersistenceService {
    public AllDepartmentItemsEvent requestAllDepartmentItems(RequestAllDepartmentItemsEvent requestAllDepartmentItemsEvent);
}