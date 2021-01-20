package com.foxminded.university.dao;

import com.foxminded.university.entity.Lecture;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Transactional
public interface LectureRepository extends CrudRepository<Lecture, Integer> {

    List<Lecture> findAllByProfessorId(int professorId);

    @Modifying(clearAutomatically = true)
    @Query(value = "update lectures set (subjectid, professorid, date, time, classroomid)  = (?, ?, ?, ?, ?) where id = ?", nativeQuery = true)
    void save(int subjectId, int professorId, LocalDate date, LocalTime time, int classroomId, int lectureId);
}
