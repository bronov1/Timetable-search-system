package com.foxminded.university.service;

import com.foxminded.university.dao.DepartmentDao;
import com.foxminded.university.entity.Department;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private final DepartmentDao departmentDao;

    public DepartmentService(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    public Department getDepartment(int id) {
        return departmentDao.get(id);
    }
}

