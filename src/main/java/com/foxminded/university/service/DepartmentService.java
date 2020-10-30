package com.foxminded.university.service;

import com.foxminded.university.dao.DepartmentDao;
import com.foxminded.university.entity.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private static final Logger logger = LoggerFactory.getLogger("DepartmentService");

    private final DepartmentDao departmentDao;

    public DepartmentService(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    public Department getDepartment(int id) {
        Department department = departmentDao.get(id);
        logger.info("Got department with {} form Database", id);
        return department;
    }
}

