package com.foxminded.university.dao;

import com.foxminded.university.entity.Group;
import com.foxminded.university.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface StudentRepository extends JpaRepository<Student, Integer> {

    void deleteByGroup(Group group);
}
