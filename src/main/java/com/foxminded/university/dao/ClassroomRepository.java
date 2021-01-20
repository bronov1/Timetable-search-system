package com.foxminded.university.dao;

import com.foxminded.university.entity.Classroom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ClassroomRepository extends CrudRepository<Classroom, Integer> {
}
