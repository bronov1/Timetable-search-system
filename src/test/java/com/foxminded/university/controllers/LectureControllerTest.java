package com.foxminded.university.controllers;

import com.foxminded.university.controller.LectureController;
import com.foxminded.university.entity.Group;
import com.foxminded.university.entity.Lecture;
import com.foxminded.university.entity.LectureGroup;
import com.foxminded.university.entity.Professor;
import com.foxminded.university.service.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;


import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class LectureControllerTest {

    @InjectMocks
    LectureController lectureController;
    @Mock
    SubjectService subjectService;
    @Mock
    ProfessorService professorService;
    @Mock
    ClassroomService classroomService;
    @Mock
    GroupService groupService;
    @Mock
    LectureService lectureService;
    @Mock
    Model model;
    @Mock
    Lecture lecture;
    @Mock
    LectureGroup lectureGroup;
    @Mock
    LectureGroupService lectureGroupService;
    @Mock
    Group group;
    @Mock
    Professor professor;

    @Test
    public void showAll() {
        lectureController.showAll(model);
        verify(lectureService).getAllLectures();
    }

    @Test
    public void showAddingForm() {
        lectureController.showAddingForm(model, lecture);
        verify(subjectService).getAllSubjects();
        verify(professorService).getAllProfessors();
        verify(classroomService).getAllClassrooms();
        verify(groupService).getAllGroups();
    }

    @Test
    public void edit() {
        lectureController.edit(model, anyInt());
        verify(lectureService).getLecture(anyInt());
        verify(subjectService).getAllSubjects();
        verify(professorService).getAllProfessors();
        verify(classroomService).getAllClassrooms();
        verify(groupService).getAllGroups();
    }

    @Test
    public void updateLecture() {
        int[] randomNumbers = new int[]{anyInt()};
        lectureController.updateLecture(lectureGroup, lecture, randomNumbers);
        verify(lectureGroupService).deleteGroupsFromLecture(lecture);
        verify(lectureGroupService).save(lectureGroup);
        verify(lectureService).update(lecture);
    }

    @Test
    public void delete() {
        lectureController.delete(lecture, anyInt());
        verify(lectureService).delete(lecture);
    }

    @Test
    public void showScheduleForm() {
        lectureController.showScheduleForm(model, group, professor);
        verify(groupService).getAllGroups();
        verify(professorService).getAllProfessors();
    }

}
