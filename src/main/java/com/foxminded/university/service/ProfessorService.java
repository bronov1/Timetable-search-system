package com.foxminded.university.service;

import com.foxminded.university.dao.ProfessorRepository;
import com.foxminded.university.entity.Lecture;
import com.foxminded.university.entity.Professor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProfessorService {

    private static final Logger logger = LoggerFactory.getLogger("ProfessorService");

    private final ProfessorRepository professorRepository;
    private final LectureService lectureService;

    public ProfessorService(ProfessorRepository professorRepository, LectureService lectureService) {
        this.professorRepository = professorRepository;
        this.lectureService = lectureService;
    }

    public List<Lecture> getProfessorSchedule(int professorId, LocalDate startDate, LocalDate finishDate){
        List<Lecture> lectures = lectureService.getProfessorPeriodLectures(getProfessor(professorId), startDate, finishDate);
        logger.info("Got schedule for professor {} for dates {} - {}", professorRepository.findById(professorId), startDate, finishDate);
        return lectures;
    }

    public Professor getProfessor(int id) {
        return professorRepository.findById(id).get();
    }

    public Iterable<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }

    public void saveProfessor(Professor professor) {
        professorRepository.save(professor);
        logger.info("Saved new professor");
    }

    public void updateProfessor(Professor professor) {
        professorRepository.save(professor);
        logger.info("Updated professor with id - {}", professor.getId());
    }

    public void deleteProfessor(Professor professor) {
        lectureService.deleteLecturesWithProfessor(professor);
        professorRepository.delete(professor);
        logger.info("Deleted professor with id - {}", professor.getId());
    }
}
