package com.foxminded.university.dao;

import com.foxminded.university.entity.Group;
import com.foxminded.university.entity.Lecture;
import com.foxminded.university.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Transactional
public interface LectureRepository extends JpaRepository<Lecture, Integer> {

    @Modifying(clearAutomatically = true)
    @Query(value = "update lectures set (subject_id, professor_id, date, time, classroom_id)  = (?, ?, ?, ?, ?) where id = ?", nativeQuery = true)
    void save(int subjectId, int professorId, LocalDate date, LocalTime time, int classroomId, int lectureId);

    List<Lecture> findAllByProfessorId(int professorId);

    List<Lecture> findAllByGroupsAndLectureDateBetween(Group group, LocalDate startDate, LocalDate finishDate);

    List<Lecture> findAllByProfessorAndLectureDateBetween(Professor professor, LocalDate startDate, LocalDate finishDate);
}
