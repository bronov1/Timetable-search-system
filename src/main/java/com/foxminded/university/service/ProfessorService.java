package com.foxminded.university.service;

import com.foxminded.university.dao.ProfessorDao;
import com.foxminded.university.entity.Lecture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProfessorService {

    private final ProfessorDao professorDao;

    @Autowired
    public ProfessorService(ProfessorDao professorDao) {
        this.professorDao = professorDao;
    }

    public List<Lecture> getProfessorMonthLectures(int professorId, LocalDate startDate, LocalDate finishDate){
        return professorDao.getProfessorMonthLectures(professorId, startDate, finishDate);
    }
}
