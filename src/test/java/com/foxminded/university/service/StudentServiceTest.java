package com.foxminded.university.service;

import com.foxminded.university.dao.StudentRepository;
import com.foxminded.university.entity.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)

public class StudentServiceTest {

    @Mock
    Student student;
    @Mock
    StudentRepository studentRepository;
    @Spy
    @InjectMocks
    StudentService StudentService;
    @Captor
    ArgumentCaptor<Integer> intCaptor;

    @Test
    public void getAllStudents() {
        StudentService.getAllStudents();
        Mockito.verify(studentRepository).findAll();
    }

    @Test
    public void getStudent() {
        int randomNumber = ArgumentMatchers.anyInt();
        StudentService.getStudent(randomNumber);
        Mockito.verify(studentRepository).findById(intCaptor.capture());
        Assertions.assertEquals(randomNumber, intCaptor.getValue());
    }

    @Test
    public void saveStudent() {
        StudentService.saveStudent(student);
        Mockito.verify(studentRepository).save(student);
    }

    @Test
    public void updateStudent() {
        StudentService.updateStudent(student);
        Mockito.verify(StudentService).updateStudent(student);
    }

    @Test
    public void deleteStudent() {
        StudentService.deleteStudent(student);
        Mockito.verify(studentRepository).delete(student);
    }
}
