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
        List<Lecture> lectures = lectureDao.getAll();
        logger.info("Got all lectures from Database");
        return lectures;
    }
}

