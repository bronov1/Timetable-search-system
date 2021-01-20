package com.foxminded.university.service;

import com.foxminded.university.dao.StudentRepository;
import com.foxminded.university.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    private static final Logger logger = LoggerFactory.getLogger("StudentService");

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void saveStudent(Student student) {
        studentRepository.save(student);
        logger.info("Saved new Student");
    }

    public Student getStudent(int id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        logger.info("Got Student with id - {}", id);
        return optionalStudent.get();
    }

    public void updateStudent(Student student) {
        studentRepository.save(student);
        logger.info("Updated Student with id - {}", student.getId());
    }

    public void deleteStudent(Student student) {
        studentRepository.delete(student);
        logger.info("Deleted Student with id - {}", student.getId());
    }
}
