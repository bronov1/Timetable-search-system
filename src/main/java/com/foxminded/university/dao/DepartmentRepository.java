package com.foxminded.university.dao;

import com.foxminded.university.entity.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface DepartmentRepository extends CrudRepository<Department, Integer> {
}
