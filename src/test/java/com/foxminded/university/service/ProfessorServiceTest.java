package com.foxminded.university.service;

import com.foxminded.university.dao.ProfessorDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class ProfessorServiceTest {

    @Mock
    ProfessorDao professorDao;
    @InjectMocks
    ProfessorService professorService;

    @Test
    public void getGroupMonthLectures_DefaultInput_DefaultOutput() {
        LocalDate startDate = LocalDate.of(2020, 10, 7);
        LocalDate finishDate = LocalDate.of(2020, 10, 14);
        professorService.getProfessorSchedule(1, startDate, finishDate);
        Mockito.verify(professorDao).getProfessorPeriodLectures(1, startDate, finishDate);
    }

    @Test
    public void getAllProfessors() {
        professorService.getAllProfessors();
        Mockito.verify(professorDao).getAll();
    }
}
