package com.foxminded.university.service;

import com.foxminded.university.dao.DepartmentRepository;
import com.foxminded.university.entity.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {

    private static final Logger logger = LoggerFactory.getLogger("DepartmentService");

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department getDepartment(int id) {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        logger.info("Got department with {} form Database", id);
        return optionalDepartment.get();
    }

    public Iterable<Department> getAllDepartments() {
        Iterable<Department> departments = departmentRepository.findAll();
        logger.info("Got all departments from Database");
        return departments;
    }
}

