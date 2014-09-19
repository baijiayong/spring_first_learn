package com.baldurtech.department.events;

import java.util.List;

import com.baldurtech.department.core.domain.Department;

public class AllDepartmentItemsEvent {
    List<Department> departments;
 
    public AllDepartmentItemsEvent(List<Department> departments) {
        this.departments = departments;
    }
    
    public List<Department> getAllDepartmentItems() {
        return departments;
    }
}