package com.foxminded.university.dao;

import com.foxminded.university.entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ClassroomRepository extends JpaRepository<Classroom, Integer> {
}
