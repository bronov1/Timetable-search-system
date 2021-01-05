package com.foxminded.university.service;

import com.foxminded.university.dao.SubjectDao;
import com.foxminded.university.entity.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    private static final Logger logger = LoggerFactory.getLogger("SubjectService");

    private final SubjectDao subjectDao;

    public SubjectService(SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }

    public Subject getSubject(int id) {
        Subject subject = subjectDao.get(id, Subject.class);
        logger.info("Got subject with  id {} from Database", id);
        return subject;
    }

    public List<Subject> getAllSubjects() {
        List<Subject> subjects = subjectDao.getAll();
        logger.info("Got all subjects from Database");
        return subjects;
    }
}
