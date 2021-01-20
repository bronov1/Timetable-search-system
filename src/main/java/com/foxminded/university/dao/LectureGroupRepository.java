package com.foxminded.university.dao;

import com.foxminded.university.entity.Group;
import com.foxminded.university.entity.Lecture;
import com.foxminded.university.entity.LectureGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface LectureGroupRepository extends JpaRepository<LectureGroup, Integer> {

    void deleteByGroup(Group group);

    void deleteByLecture(Lecture lecture);

    @Modifying(clearAutomatically = true)
    @Query(value = "insert into lecturegroups (lecture_id, group_id) values (?, ?)", nativeQuery = true)
    void save(int lectureId, int groupId);
}
