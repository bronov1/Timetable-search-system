package com.foxminded.university.service;

import com.foxminded.university.dao.LectureGroupRepository;
import com.foxminded.university.dao.LectureRepository;
import com.foxminded.university.entity.Lecture;
import com.foxminded.university.entity.Professor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class LectureService {

    private static final Logger logger = LoggerFactory.getLogger("LectureService");

    private final LectureRepository lectureRepository;
    private final LectureGroupRepository lectureGroupRepository;

    public LectureService(LectureRepository lectureRepository, LectureGroupRepository lectureGroupRepository) {
        this.lectureRepository = lectureRepository;
        this.lectureGroupRepository = lectureGroupRepository;
    }

    public Iterable<Lecture> getAllLectures() {
        Iterable<Lecture> lectures = lectureRepository.findAll();
        logger.info("Got all lectures from Database");
        return lectures;
    }

    public void save(Lecture lecture) {
        lectureRepository.save(lecture);
        logger.info("Saved new lecture");
    }

    public void delete(Lecture lecture) {
        lectureGroupRepository.deleteByLecture(lecture);
        lectureRepository.delete(lecture);
        logger.info("Deleted lecture with id - {}", lecture.getId());
    }

    public void update(Lecture lecture) {
        int subjectId = lecture.getSubject().getId();
        int classroomId = lecture.getClassroom().getId();
        int professorId = lecture.getProfessor().getId();
        LocalDate date = lecture.getLectureDate();
        LocalTime time = lecture.getLectureTime();
        lectureRepository.save(subjectId, professorId, date, time, classroomId, lecture.getId());
        logger.info("Updated lecture with id - {}", lecture.getId());
    }

    public Lecture getLecture(int id) {
        Optional<Lecture> optionalLecture = lectureRepository.findById(id);
        logger.info("Got lecture with id - {}", id);
        return optionalLecture.get();
    }

    public void deleteLecturesWithProfessor(Professor professor) {
        List<Lecture> lecturesWithProfessor = lectureRepository.findAllByProfessorId(professor.getId());
        for (Lecture lecture : lecturesWithProfessor) {
            delete(lecture);
        }
    }

    public List<Lecture> getProfessorPeriodLectures(Professor professor, LocalDate startDate, LocalDate finishDate) {
        List<Lecture> lectures = lectureRepository.findAllByProfessorAndLectureDateBetween(professor, startDate, finishDate);
        logger.info("Got lectures for professor with id - {} between {} ans {}", professor.getId(), startDate, finishDate);
        return lectures;
    }

}

