package com.foxminded.university.service;

import com.foxminded.university.dao.StudentDao;
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
    StudentDao studentDao;
    @Spy
    @InjectMocks
    StudentService StudentService;
    @Captor
    ArgumentCaptor<Integer> intCaptor;

    @Test
    public void getAllStudents() {
        StudentService.getAllStudents();
        Mockito.verify(studentDao).getAll();
    }

    @Test
    public void getStudent() {
        int randomNumber = ArgumentMatchers.anyInt();
        StudentService.getStudent(randomNumber);
        Mockito.verify(studentDao).get(intCaptor.capture());
        Assertions.assertEquals(randomNumber, intCaptor.getValue());
    }

    @Test
    public void saveStudent() {
        StudentService.saveStudent(student);
        Mockito.verify(studentDao).save(student);
    }

    @Test
    public void updateStudent() {
        StudentService.updateStudent(student);
        Mockito.verify(StudentService).updateStudent(student);
    }

    @Test
    public void deleteStudent() {
        StudentService.deleteStudent(student);
        Mockito.verify(studentDao).delete(student);
    }
}
