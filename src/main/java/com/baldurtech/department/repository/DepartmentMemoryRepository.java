package com.baldurtech.department.repository;

import com.baldurtech.department.core.domain.Department;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.ArrayList;

public class DepartmentMemoryRepository implements DepartmentRepository {
    
    public List<Department> findAllDepartment() {
        Department department1 = new Department();
        Department department2 = new Department();
        
        List<Department> departments = new ArrayList<Department>();
        
        department1.setName("Human Resource");
        department1.setAddress("BeiZhang");
        department1.setMemo("Computer science and technology");
        department1.setParent("Baldurtech");
        
        department2.setName("Technology");
        department2.setAddress("BeiZhang");
        department2.setMemo("Computer science and technology");
        department2.setParent("Baldurtech");
        
        departments.add(department1);
        departments.add(department2);
        
        return departments;
    }
}
