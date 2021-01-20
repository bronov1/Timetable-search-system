package com.foxminded.university.dao;

import com.foxminded.university.entity.LectureGroup;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface LectureGroupRepository extends CrudRepository<LectureGroup, Integer> {

    void deleteByGroupId(int groupId);

    void deleteByLectureId(int lectureId);

    @Modifying(clearAutomatically = true)
    @Query(value = "insert into lecturegroups (lectureid, groupid) values (?, ?)", nativeQuery = true)
    void save(int lectureId, int groupId);
}
