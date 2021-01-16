package com.foxminded.university.service;

import com.foxminded.university.dao.LectureDao;
import com.foxminded.university.entity.Lecture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectureService {

    private static final Logger logger = LoggerFactory.getLogger("LectureService");

    private final LectureDao lectureDao;

    public LectureService(LectureDao lectureDao) {
        this.lectureDao = lectureDao;
    }

    public List<Lecture> getAllLectures() {
        List<Lecture> lectures = lectureDao.findAll(Lecture.class);
        logger.info("Got all lectures from Database");
        return lectures;
    }

    public void save(Lecture lecture) {
        lectureDao.save(lecture);
        logger.info("Saved new lecture");
    }

    public void delete(Lecture lecture) {
        lectureDao.delete(lecture);
        logger.info("Deleted lecture with id - {}", lecture.getId());
    }

    public void update(Lecture lecture) {
        lectureDao.save(lecture);
        logger.info("Updated lecture with id - {}", lecture.getId());
    }

    public Lecture getLecture(int id) {
        Lecture lecture = lectureDao.findById(id, Lecture.class);
        logger.info("Got lecture with id - {}", id);
        return lecture;
    }
}

