package com.foxminded.university.service;

import com.foxminded.university.dao.ClassroomDao;
import com.foxminded.university.entity.Classroom;
import org.springframework.stereotype.Service;

@Service
public class ClassroomService {

    private final ClassroomDao classroomDao;

    public ClassroomService(ClassroomDao classroomDao) {
        this.classroomDao = classroomDao;
    }

    public Classroom getClassroom(int id) {
        return classroomDao.get(id);
    }
}
