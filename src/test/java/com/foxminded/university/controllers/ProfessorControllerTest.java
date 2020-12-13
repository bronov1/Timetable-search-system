package com.foxminded.university.controllers;

import com.foxminded.university.controller.ProfessorController;
import com.foxminded.university.entity.Professor;
import com.foxminded.university.service.ProfessorService;
import com.foxminded.university.service.DepartmentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ProfessorControllerTest {

    @InjectMocks
    ProfessorController professorController;
    @Mock
    DepartmentService departmentService;
    @Mock
    ProfessorService professorService;
    @Mock
    Model model;
    @Mock
    Professor professor;

    @Test
    public void showAll() {
        professorController.showAll(model);
        verify(professorService).getAllProfessors();
    }

    @Test
    public void showAddingForm() {
        professorController.showAddingForm(professor, model);
        verify(departmentService).getAllDepartments();
    }

    @Test
    public void saveNewProfessor() {
        professorController.saveNewProfessor(professor);
        verify(professorService).saveProfessor(professor);
    }

    @Test
    public void edit() {
        professorController.edit(anyInt(), model);
        verify(professorService).getProfessor(anyInt());
        verify(departmentService).getAllDepartments();
    }

    @Test
    public void updateProfessor() {
        professorController.updateProfessor(professor);
        verify(professorService).updateProfessor(professor);
    }

    @Test
    public void delete() {
        professorController.delete(professor, anyInt());
        verify(professor).setId(anyInt());
        verify(professorService).deleteProfessor(professor);
    }
}
