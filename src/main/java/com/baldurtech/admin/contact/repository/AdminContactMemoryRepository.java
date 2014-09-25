package com.baldurtech.admin.contact.repository;

import com.baldurtech.contact.dbManager.DbManager;
import com.baldurtech.contact.dbManager.RowMapperImpl;
import com.baldurtech.contact.core.domain.Contact;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.ArrayList;

public class AdminContactMemoryRepository implements AdminContactRepository {
    DbManager dbManager = new DbManager();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(dbManager.driverManager());
    String sql;
    
    @Override
    public List<Contact> findAllContacts() {
        sql = "SELECT * FROM contact";
        return dbManager.executeQuery(jdbcTemplate,sql);
    }
    
    @Override
    public Contact getById(Contact contact) {
        sql = "SELECT * FROM contact WHERE id=?";
        return dbManager.executeQueryById(jdbcTemplate,sql,contact);
    }
    
    @Override
    public Contact create(Contact contact) {
        sql = "INSERT INTO contact(name, mobile, email, vpmn, office_address, home_address, memo, job, job_level) values(?,?,?,?,?,?,?,?,?)";
        return dbManager.insert(jdbcTemplate,sql,contact);
    }
    
    @Override
    public Contact delete(Contact contact) {
        sql = "DELETE FROM contact WHERE id=?";
        return dbManager.delete(jdbcTemplate, sql, contact);
    }
    
    @Override
    public Contact update(Contact updateContact, Contact contact) {
        sql = "UPDATE contact SET name=?, mobile=?, email=?, vpmn=?, office_address=?, home_address=?, memo=?, job=?, job_level=? WHERE id=?";
        return dbManager.update(jdbcTemplate,sql,updateContact,contact);
    }
}
