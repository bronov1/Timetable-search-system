package com.foxminded.university.dao;

import com.foxminded.university.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface StudentRepository extends CrudRepository<Student, Integer> {

    void deleteByGroupId(int groupId);
}
