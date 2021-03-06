package com.foxminded.university.dao;

import com.foxminded.university.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
