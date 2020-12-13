package com.foxminded.university.controllers;

import com.foxminded.university.controller.StudentController;
import com.foxminded.university.entity.Student;
import com.foxminded.university.service.GroupService;
import com.foxminded.university.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @InjectMocks
    StudentController studentController;
    @Mock
    GroupService groupService;
    @Mock
    StudentService studentService;
    @Mock
    Model model;
    @Mock
    Student student;

    @Test
    public void showAll() {
        studentController.showAll(model);
        verify(studentService).getAllStudents();
    }

    @Test
    public void showAddingForm() {
        studentController.showAddingForm(student, model);
        verify(groupService).getAllGroups();
    }

    @Test
    public void saveNewStudent() {
        studentController.saveNewStudent(student);
        verify(studentService).saveStudent(student);
    }

    @Test
    public void edit() {
        studentController.edit(anyInt(), model);
        verify(studentService).getStudent(anyInt());
        verify(groupService).getAllGroups();
    }

    @Test
    public void updateStudent() {
        studentController.updateStudent(student);
        verify(studentService).updateStudent(student);
    }

    @Test
    public void delete() {
        studentController.delete(student, anyInt());
        verify(student).setId(anyInt());
        verify(studentService).deleteStudent(student);
    }
}
