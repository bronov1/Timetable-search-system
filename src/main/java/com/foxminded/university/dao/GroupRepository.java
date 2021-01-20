package com.foxminded.university.dao;

import com.foxminded.university.entity.Group;
import com.foxminded.university.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface GroupRepository extends JpaRepository<Group, Integer> {

    List<Group> findAllByLectures(Lecture lecture);
}
