package com.baldurtech.department.events;

import com.baldurtech.department.core.domain.Department;

import java.util.List;

public class DepartmentDetailsEvent {
    List<Department> departments;
    
    public DepartmentDetailsEvent(List<Department> departments) {
        this.departments = departments;
    }
    
    public List<Department> getDepartmentDetails() {
        return departments;
    }
}