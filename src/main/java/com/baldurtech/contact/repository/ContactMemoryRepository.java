
package com.baldurtech.contact.repository;

import java.util.List;
import java.util.ArrayList;

import com.baldurtech.contact.dbManager.DbManager;
import com.baldurtech.contact.dbManager.RowMapperImpl;
import com.baldurtech.contact.core.domain.Contact;

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
        return dbManager.executeQueryById(jdbcTemplate,sql,id);
    }
}