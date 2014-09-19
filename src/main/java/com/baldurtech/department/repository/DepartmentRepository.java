package com.baldurtech.department.repository;

import com.baldurtech.department.core.domain.Department;

import java.util.List;

public interface DepartmentRepository {
    public List<Department> findAllDepartment();
}