package com.baldurtech.department.core.service;

import com.baldurtech.department.events.RequestAllDepartmentItemsEvent;
import com.baldurtech.department.events.AllDepartmentItemsEvent;

public interface DepartmentService {
    public AllDepartmentItemsEvent allDepartmentList(RequestAllDepartmentItemsEvent requestAllDepartmentItemsEvent);
}