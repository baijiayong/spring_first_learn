package com.baldurtech.dbManager;

import com.baldurtech.core.Contact;

import javax.sql.DataSource;
import java.util.List;

import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

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
                    + "job varchar(255),job_level integer(11))");
                            
        System.out.println("Inserting contact record!");
        
        jdbcTemplate.update("INSERT INTO contact(id,name,mobile,email,vpmn,office_address,home_address,memo,job,job_level) values(?,?,?,?,?,?,?,?,?,?)", 1L, "ShiHang", "18222222222","shihang@gmail.com","62222","BeiZhang","TaiYuan"," a beautiful girl","HR",1L);
        jdbcTemplate.update("INSERT INTO contact(id,name,mobile,email,vpmn,office_address,home_address,memo,job,job_level) values(?,?,?,?,?,?,?,?,?,?)", 2L, "XiaoBai", "18222222222","shihang@gmail.com","62222","BeiZhang","TaiYuan"," a beautiful girl","HR",1L);
        jdbcTemplate.update("INSERT INTO contact(id,name,mobile,email,vpmn,office_address,home_address,memo,job,job_level) values(?,?,?,?,?,?,?,?,?,?)", 3L, "XuShuang", "18222222222","shihang@gmail.com","62222","BeiZhang","TaiYuan"," a beautiful girl","HR",1L);
        jdbcTemplate.update("INSERT INTO contact(id,name,mobile,email,vpmn,office_address,home_address,memo,job,job_level) values(?,?,?,?,?,?,?,?,?,?)", 4L, "HaoYufei", "18222222222","shihang@gmail.com","62222","BeiZhang","TaiYuan"," a beautiful girl","HR",1L);
        jdbcTemplate.update("INSERT INTO contact(id,name,mobile,email,vpmn,office_address,home_address,memo,job,job_level) values(?,?,?,?,?,?,?,?,?,?)", 5L, "RenJian", "18222222222","shihang@gmail.com","62222","BeiZhang","TaiYuan"," a beautiful girl","HR",1L);
    }
    
    public List<Contact> executeQuery(JdbcTemplate jdbcTemplate)
    {
        String sql = "SELECT * FROM contact";  
        Object[] params = new Object[] {};
        return jdbcTemplate.query(sql, params, new RowMapperImpl());      
    }
}