package com.foxminded.university.service;

import com.foxminded.university.dao.SubjectDao;
import com.foxminded.university.entity.Subject;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {

    private final SubjectDao subjectDao;

    public SubjectService(SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }

    public Subject getSubject(int id) {
        return subjectDao.get(id);
    }
}
