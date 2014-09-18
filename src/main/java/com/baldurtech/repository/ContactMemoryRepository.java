package com.baldurtech.repository;

import java.util.List;
import java.util.ArrayList;

import com.baldurtech.dbManager.DbManager;
import com.baldurtech.dbManager.RowMapperImpl;
import com.baldurtech.core.Contact;

import org.springframework.jdbc.core.JdbcTemplate;

public class ContactMemoryRepository implements ContactRepository {
    DbManager dbManager = new DbManager();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(dbManager.driverManager());
    String sql;
    
    @Override
    public List<Contact> findAllContact() {
        sql = "SELECT * FROM contact";
        return dbManager.executeQuery(jdbcTemplate,sql);
    }
     
    @Override
    public List<Contact> getById(Long id) {
        sql = "SELECT * FROM contact WHERE id=?";
        return dbManager.executeQuery(jdbcTemplate,sql,id);
    }
}