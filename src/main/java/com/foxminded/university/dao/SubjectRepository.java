package com.foxminded.university.dao;

import com.foxminded.university.entity.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface SubjectRepository extends CrudRepository<Subject, Integer> {
}
