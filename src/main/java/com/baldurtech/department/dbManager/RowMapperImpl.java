package com.baldurtech.department.dbManager;

import com.baldurtech.department.core.domain.Department;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class RowMapperImpl implements RowMapper
{
    @Override
    public Department mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        Department department = new Department();
        department.setId(rs.getLong("id"));
        department.setName(rs.getString("name"));
        department.setAddress(rs.getString("address"));
        department.setMemo(rs.getString("memo"));
        department.setParent(rs.getString("parent"));
        return department;
    }
}