package com.baldurtech.department.repository;

import com.baldurtech.department.core.domain.Department;
import com.baldurtech.department.dbManager.DbManager;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.ArrayList;

public class DepartmentMemoryRepository implements DepartmentRepository {
    
    DbManager dbManager = new DbManager();
   
    @Override
    public List<Department> findAllDepartment() {
        return dbManager.executeQuery();
    }
     
    @Override
    public Department getById(Department department) {
        return dbManager.executeQueryById(department);
    }
}
