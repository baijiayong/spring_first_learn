package com.baldurtech.contact.dbManager;

import com.baldurtech.contact.core.domain.Contact;

import javax.sql.DataSource;
import java.util.List;
import java.util.ArrayList;

import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.dao.DataAccessException;

public class DbManager
{
    public DataSource driverManager()
    {

        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
        dataSource.setUsername("root");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test");
        dataSource.setPassword("");
        return dataSource;
    }
    
    public void insert(JdbcTemplate jdbcTemplate)
    {
        jdbcTemplate.execute("drop table if exists contact");
        jdbcTemplate.execute("create table contact(" 
                    + "id serial, name varchar(255), mobile varchar(255)," 
                    + "email varchar(255),vpmn varchar(255),office_address varchar(255)," 
                    + "home_address varchar(255),memo varchar(255)," 
                    + "job varchar(255),job_level integer(200))");
                            
        System.out.println("Inserting contact record!");
        
        jdbcTemplate.update("INSERT INTO contact(id,name,mobile,email,vpmn,office_address,home_address,memo,job,job_level) values(?,?,?,?,?,?,?,?,?,?)", 1L, "ShiHang", "18222222222","shihang@gmail.com","62222","BeiZhang","TaiYuan"," a beautiful girl","HR",1L);
        jdbcTemplate.update("INSERT INTO contact(id,name,mobile,email,vpmn,office_address,home_address,memo,job,job_level) values(?,?,?,?,?,?,?,?,?,?)", 2L, "XiaoBai", "18222222222","shihang@gmail.com","62222","BeiZhang","TaiYuan"," a beautiful girl","HR",1L);
        jdbcTemplate.update("INSERT INTO contact(id,name,mobile,email,vpmn,office_address,home_address,memo,job,job_level) values(?,?,?,?,?,?,?,?,?,?)", 3L, "XuShuang", "18222222222","shihang@gmail.com","62222","BeiZhang","TaiYuan"," a beautiful girl","HR",1L);
        jdbcTemplate.update("INSERT INTO contact(id,name,mobile,email,vpmn,office_address,home_address,memo,job,job_level) values(?,?,?,?,?,?,?,?,?,?)", 4L, "HaoYufei", "18222222222","shihang@gmail.com","62222","BeiZhang","TaiYuan"," a beautiful girl","HR",1L);
        jdbcTemplate.update("INSERT INTO contact(id,name,mobile,email,vpmn,office_address,home_address,memo,job,job_level) values(?,?,?,?,?,?,?,?,?,?)", 5L, "RenJian", "18222222222","shihang@gmail.com","62222","BeiZhang","TaiYuan"," a beautiful girl","HR",1L);
    }
    
    public List<Contact> executeQuery(JdbcTemplate jdbcTemplate, String sql)
    { 
        Object[] params = new Object[] {};
        
        return jdbcTemplate.query(sql, params, new RowMapperImpl());  
    }
    
    public Contact executeQueryById(JdbcTemplate jdbcTemplate, String sql, Contact contact)
    { 
        Object[] params = new Object[] {contact.getId()};
        
        List<Contact> result=  jdbcTemplate.query(sql, params, new RowMapperImpl());  
        
        if(result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }
    
      public Contact insert(JdbcTemplate jdbcTemplate, String sql, Contact contact)
    {
        Object[] params = new Object[] {contact.getName(), contact.getMobile(), contact.getEmail(), contact.getVpmn(), contact.getOfficeAddress(), contact.getHomeAddress(), contact.getMemo(), contact.getJob(), contact.getJobLevel()};
        jdbcTemplate.update(sql, params);
        return contact;
    }
    
    public Contact update(JdbcTemplate jdbcTemplate, String sql, Contact updateContact, Contact contact)
    {
        Object[] params = new Object[] {updateContact.getName(), updateContact.getMobile(), updateContact.getEmail(), updateContact.getVpmn(), updateContact.getOfficeAddress(), updateContact.getHomeAddress(), updateContact.getMemo(), updateContact.getJob(), updateContact.getJobLevel(), contact.getId()};
        jdbcTemplate.update(sql, params);
        return updateContact;
    }
    
    public Contact delete(JdbcTemplate jdbcTemplate, String sql, Contact contact)
    {
        Object[] params = new Object[] {contact.getId()};
        jdbcTemplate.update(sql, params);
        return contact;
    }
}