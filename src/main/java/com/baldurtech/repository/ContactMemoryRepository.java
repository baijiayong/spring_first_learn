package com.baldurtech.repository;

import java.util.List;
import java.util.ArrayList;

import com.baldurtech.dbManager.DbManager;
import com.baldurtech.dbManager.RowMapperImpl;
import com.baldurtech.core.Contact;

import org.springframework.jdbc.core.JdbcTemplate;

public class ContactMemoryRepository implements ContactRepository {
 
    @Override
    public List<Contact> findAllContact() {
       DbManager dbManager = new DbManager();
       JdbcTemplate jdbcTemplate = new JdbcTemplate(dbManager.driverManager());
       return dbManager.executeQuery(jdbcTemplate);
    }
     
    @Override
    public Contact getById(Long id) {
        Contact contact = new Contact();
        contact.setId(id);
        contact.setName("Xu Shuangshuang");
        contact.setMobile("18766666666");
        contact.setVpmn("69999");
        contact.setEmail("Xu@gmail.com");
        
        return contact;
    }
}