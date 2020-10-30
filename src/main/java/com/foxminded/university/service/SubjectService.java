package com.foxminded.university.service;

import com.foxminded.university.dao.SubjectDao;
import com.foxminded.university.entity.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {

    private static final Logger logger = LoggerFactory.getLogger("SubjectService");

    private final SubjectDao subjectDao;

    public SubjectService(SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }

    public Subject getSubject(int id) {
        Subject subject = subjectDao.get(id);
        logger.info("Got subject with {} form Database", id);
        return subject;
    }
}
