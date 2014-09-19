package com.baldurtech.department.events;

import com.baldurtech.department.core.domain.Department;

public class DepartmentDetailsEvent {
    Department department;
    
    public DepartmentDetailsEvent(Department department) {
        this.department = department;
    }
    
    public Department getDepartmentDetails() {
        return department;
    }
}