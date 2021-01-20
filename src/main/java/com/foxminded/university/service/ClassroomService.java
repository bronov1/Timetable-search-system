package com.foxminded.university.service;

import com.foxminded.university.dao.ClassroomRepository;
import com.foxminded.university.entity.Classroom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassroomService {

    private static final Logger logger = LoggerFactory.getLogger("ClassroomService");

    private final ClassroomRepository classroomRepository;

    public ClassroomService(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    public Classroom getClassroom(int id) {
        Optional<Classroom> optionalClassroom = classroomRepository.findById(id);
        logger.info("Got classroom with id {} from Database", id);
        return optionalClassroom.get();
    }

    public Iterable<Classroom> getAllClassrooms() {
        Iterable<Classroom> classrooms = classroomRepository.findAll();
        logger.info("Gor all classrooms form Database");
        return classrooms;
    }
}
