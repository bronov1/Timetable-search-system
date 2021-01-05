package com.foxminded.university.service;

import com.foxminded.university.dao.ClassroomDao;
import com.foxminded.university.entity.Classroom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomService {

    private static final Logger logger = LoggerFactory.getLogger("ClassroomService");

    private final ClassroomDao classroomDao;

    public ClassroomService(ClassroomDao classroomDao) {
        this.classroomDao = classroomDao;
    }

    public Classroom getClassroom(int id) {
        Classroom classroom = classroomDao.get(id, Classroom.class);
        logger.info("Got classroom with id {} from Database", id);
        return classroom;
    }

    public List<Classroom> getAllClassrooms() {
        List<Classroom> classrooms = classroomDao.getAll();
        logger.info("Gor all classrooms form Database");
        return classrooms;
    }
}
