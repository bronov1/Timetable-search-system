package com.foxminded.university.dao;

import com.foxminded.university.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentDao implements Dao<Department>{

    private static final String GET_DEPARTMENT = "Select * from departments where id = ?";
    private static final String GET_ALL_DEPARTMENTS = "Select * from departments";
    private static final String SAVE_DEPARTMENT = "Insert into departments (name) values (?)";
    private static final String UPDATE_DEPARTMENT = "Update departments set (name)  = (?) where id = ?";
    private static final String DELETE_DEPARTMENT = "Delete from departments where id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Department get(int id) {
        return jdbcTemplate.queryForObject(GET_DEPARTMENT, new Object[]{id}, new BeanPropertyRowMapper<>(Department.class));
    }

    @Override
    public List<Department> getAll() {
        return jdbcTemplate.query(GET_ALL_DEPARTMENTS, new BeanPropertyRowMapper<>(Department.class));
    }

    @Override
    public void save(Department department) {
        jdbcTemplate.update(SAVE_DEPARTMENT, department.getName());
    }

    @Override
    public void update(Department department, Object[] params) {
        jdbcTemplate.update(UPDATE_DEPARTMENT, params[0], department.getId());
    }

    @Override
    public void delete(Department department) {
        jdbcTemplate.update(DELETE_DEPARTMENT, department.getId());
    }
}
