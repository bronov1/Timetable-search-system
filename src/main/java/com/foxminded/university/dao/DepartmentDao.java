package com.foxminded.university.dao;

import com.foxminded.university.entity.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentDao implements Dao<Department>{

    private static final Logger logger = LoggerFactory.getLogger("DepartmentDao");

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
        Department department = jdbcTemplate.queryForObject(GET_DEPARTMENT, new Object[]{id}, new BeanPropertyRowMapper<>(Department.class));
        logger.info("Объект {} взят из базы", department.getClass());
        return department;
    }

    @Override
    public List<Department> getAll() {
        List<Department> departments = jdbcTemplate.query(GET_ALL_DEPARTMENTS, new BeanPropertyRowMapper<>(Department.class));
        logger.info("Список обектов {} взят из базы", departments.getClass());
        return departments;
    }

    @Override
    public void save(Department department) {
        jdbcTemplate.update(SAVE_DEPARTMENT, department.getName());
        logger.info("Объект {} сохранен в базу", department.getClass());
    }

    @Override
    public void update(Department department, Object[] params) {
        jdbcTemplate.update(UPDATE_DEPARTMENT, params[0], department.getId());
        logger.info("Объект {} обновлен", department.getClass());
    }

    @Override
    public void delete(Department department) {
        jdbcTemplate.update(DELETE_DEPARTMENT, department.getId());
        logger.info("Объект {} удален из базы", department.getClass());
    }
}
