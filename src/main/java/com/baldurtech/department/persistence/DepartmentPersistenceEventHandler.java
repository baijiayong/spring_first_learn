package com.baldurtech.department.persistence;

import com.baldurtech.department.core.domain.Department;
import com.baldurtech.department.repository.DepartmentRepository;
import com.baldurtech.department.events.RequestAllDepartmentItemsEvent;
import com.baldurtech.department.events.AllDepartmentItemsEvent;
import com.baldurtech.department.events.RequestDepartmentDetailsEvent;
import com.baldurtech.department.events.DepartmentDetailsEvent;

import java.util.List;

public class DepartmentPersistenceEventHandler implements DepartmentPersistenceService {
    DepartmentRepository departmentRepository;
    
    public DepartmentPersistenceEventHandler(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
    
    @Override
    public AllDepartmentItemsEvent requestAllDepartmentItems (RequestAllDepartmentItemsEvent requestAllDepartmentItemsEvent) {
        List<Department> departments = departmentRepository.findAllDepartment();
        return new AllDepartmentItemsEvent(departments);
    }
    
    @Override
    public DepartmentDetailsEvent requestDepartmentDetails (RequestDepartmentDetailsEvent requestDepartmentDetailsEvent, Department department) {
        return new DepartmentDetailsEvent(departmentRepository.getById(department));
    }
}