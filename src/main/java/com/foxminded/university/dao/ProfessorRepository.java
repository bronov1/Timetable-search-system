package com.foxminded.university.dao;

import com.foxminded.university.entity.Lecture;
import com.foxminded.university.entity.Professor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Transactional
public interface ProfessorRepository extends CrudRepository<Professor, Integer> {

    @Query("SELECT l FROM Lecture l WHERE l.professor = :professor AND l.date BETWEEN :startDate AND :finishDate")
    List<Lecture> getProfessorPeriodLectures(@Param("professor") Professor professor,
                                             @Param("startDate") LocalDate startDate,
                                             @Param("finishDate") LocalDate finishDate);
}
