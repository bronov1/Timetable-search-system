package com.foxminded.university.service;

import com.foxminded.university.dao.SubjectRepository;
import com.foxminded.university.entity.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    private static final Logger logger = LoggerFactory.getLogger("SubjectService");

    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public Subject getSubject(int id) {
        Optional<Subject> optionalSubject = subjectRepository.findById(id);
        logger.info("Got subject with  id {} from Database", id);
        return optionalSubject.get();
    }

    public Iterable<Subject> getAllSubjects() {
        Iterable<Subject> subjects = subjectRepository.findAll();
        logger.info("Got all subjects from Database");
        return subjects;
    }
}
