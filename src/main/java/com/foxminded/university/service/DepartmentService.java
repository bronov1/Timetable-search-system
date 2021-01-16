package com.foxminded.university.service;

import com.foxminded.university.dao.DepartmentDao;
import com.foxminded.university.entity.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private static final Logger logger = LoggerFactory.getLogger("DepartmentService");

    private final DepartmentDao departmentDao;

    public DepartmentService(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    public Department getDepartment(int id) {
        Department department = departmentDao.findById(id, Department.class);
        logger.info("Got department with {} form Database", id);
        return department;
    }

    public List<Department> getAllDepartments() {
        List<Department> departments = departmentDao.findAll(Department.class);
        logger.info("Got all departments from Database");
        return departments;
    }
}

