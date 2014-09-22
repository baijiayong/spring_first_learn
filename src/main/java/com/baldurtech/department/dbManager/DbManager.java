package com.baldurtech.department.dbManager;

import com.baldurtech.department.core.domain.Department;

import javax.sql.DataSource;
import java.util.List;

import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class DbManager {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(driverManager());
    
    public DataSource driverManager() {

        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
        dataSource.setUsername("root");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test");
        dataSource.setPassword("");
        return dataSource;
    }
    
    public List<Department> executeQuery() {
        String sql = "SELECT * FROM department";  
        Object[] params = new Object[] {};
        return jdbcTemplate.query(sql, params, new RowMapperImpl());      
    }
    
    public Department executeQueryById(Department department) {
        String sql = "SELECT * FROM department WHERE id=?";
        Object[] params = new Object[] {department.getId()};       
        List<Department> result = jdbcTemplate.query(sql, params, new RowMapperImpl());
        if(result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }
}