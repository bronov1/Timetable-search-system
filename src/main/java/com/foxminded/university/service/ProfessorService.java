package com.foxminded.university.service;

import com.foxminded.university.dao.ProfessorDao;
import com.foxminded.university.entity.Lecture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProfessorService {

    private static final Logger logger = LoggerFactory.getLogger("ProfessorService");

    private final ProfessorDao professorDao;

    @Autowired
    public ProfessorService(ProfessorDao professorDao) {
        this.professorDao = professorDao;
    }

    public List<Lecture> getProfessorSchedule(int professorId, LocalDate startDate, LocalDate finishDate){
        List<Lecture> lectures = professorDao.getProfessorPeriodLectures(professorId, startDate, finishDate);
        logger.info("Получено расписание для профессора {} на даты {} - {}", professorDao.get(professorId), startDate, finishDate);
        return lectures;
    }
}
