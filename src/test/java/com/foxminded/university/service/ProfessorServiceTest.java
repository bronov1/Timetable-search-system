package com.foxminded.university.service;

import com.foxminded.university.dao.ProfessorDao;
import com.foxminded.university.entity.Professor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class ProfessorServiceTest {

    @Mock
    Professor professor;
    @Mock
    ProfessorDao professorDao;
    @Spy
    @InjectMocks
    ProfessorService professorService;
    @Captor
    ArgumentCaptor<Integer> intCaptor;
    @Captor
    ArgumentCaptor<LocalDate> dateCaptor;

    @Test
    public void getGroupMonthLectures_DefaultInput_DefaultOutput() {
        int randomNumber = ArgumentMatchers.anyInt();
        LocalDate randomStartDate = ArgumentMatchers.any(LocalDate.class);
        LocalDate randomFinishDate = ArgumentMatchers.any(LocalDate.class);
        professorService.getProfessorSchedule(randomNumber, randomStartDate, randomFinishDate);
        Mockito.verify(professorDao).getProfessorPeriodLectures(intCaptor.capture(), dateCaptor.capture(), dateCaptor.capture());
        Assertions.assertEquals(randomNumber, intCaptor.getValue());
        Assertions.assertEquals(randomStartDate, dateCaptor.getValue());
        Assertions.assertEquals(randomFinishDate, dateCaptor.getValue());
    }

    @Test
    public void getAllProfessors() {
        professorService.getAllProfessors();
        Mockito.verify(professorDao).findAll(Professor.class);
    }

    @Test
    public void getProfessor() {
        int randomNumber = ArgumentMatchers.anyInt();
        professorService.getProfessor(randomNumber);
        Mockito.verify(professorDao).findById(intCaptor.capture(), Professor.class);
        Assertions.assertEquals(randomNumber, intCaptor.getValue());
    }

    @Test
    public void saveProfessor() {
        professorService.saveProfessor(professor);
        Mockito.verify(professorDao).save(professor);
    }

    @Test
    public void updateProfessor() {
        professorService.updateProfessor(professor);
        Mockito.verify(professorService).updateProfessor(professor);
    }

    @Test
    public void deleteProfessor() {
        professorService.deleteProfessor(professor);
        Mockito.verify(professorDao).delete(professor);
    }
}
