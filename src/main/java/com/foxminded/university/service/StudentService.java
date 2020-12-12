package com.foxminded.university.service;

import com.foxminded.university.dao.StudentDao;
import com.foxminded.university.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private static final Logger logger = LoggerFactory.getLogger("StudentService");

    private final StudentDao studentDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public List<Student> getAllStudents() {
        return studentDao.getAll();
    }

    public void saveStudent(Student student) {
        studentDao.save(student);
        logger.info("Saved new Student");
    }

    public Student getStudent(int id) {
        Student student = studentDao.get(id);
        logger.info("Got Student with id - {}", id);
        return student;
    }

    public void updateStudent(Student student) {
        Object[] parameters = new Object[]{student.getName(), student.getGroupId()};
        studentDao.update(student, parameters);
        logger.info("Updated Student with id - {}", student.getId());
    }

    public void deleteStudent(Student student) {
        studentDao.delete(student);
        logger.info("Deleted Student with id - {}", student.getId());
    }
}
