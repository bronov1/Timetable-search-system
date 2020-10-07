package com.foxminded.university.dao;

import com.foxminded.university.entity.Department;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentDao implements Dao<Department>{

    private static final String GET_DEPARTMENT = "SELECT * FROM DEPARTMENTS WHERE ID = ?";
    private static final String GET_ALL_DEPARTMENTS = "SELECT * FROM DEPARTMENTS";
    private static final String SAVE_DEPARTMENT = "INSERT INTO DEPARTMENTS (NAME) VALUES (?)";
    private static final String UPDATE_DEPARTMENT = "UPDATE DEPARTMENTS SET NAME  = ? WHERE ID = ?";
    private static final String DELETE_DEPARTMENT = "DELETE FROM DEPARTMENTS WHERE ID = ?";

    private final JdbcTemplate jdbcTemplate;

    public DepartmentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

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
