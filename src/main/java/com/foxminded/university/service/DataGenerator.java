package com.foxminded.university.service;

import com.foxminded.university.dao.*;
import com.foxminded.university.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class DataGenerator {

    @Autowired
    SubjectDao subjectDao;
    @Autowired
    LectureGroupDao lectureGroupDao;
    @Autowired
    LectureDao lectureDao;
    @Autowired
    StreamDao streamDao;
    @Autowired
    GroupDao groupDao;
    @Autowired
    StudentDao studentDao;
    @Autowired
    ProfessorDao professorDao;
    @Autowired
    DepartmentDao departmentDao;
    @Autowired
    ClassroomDao classroomDao;
    @Autowired
    FloorDao floorDao;
    @Autowired
    BuildingDao buildingDao;
    @Autowired
    FileReader fileReader;
    @Autowired
    ScriptRunner scriptRunner;

    @PostConstruct
    public void createTables() throws URISyntaxException, IOException {
        Path scriptPath = fileReader.getFilePath("createTables.sql");
        scriptRunner.executeScript(scriptPath);
        generateData();
    }

    public void generateData() {
        generateBuildings();
        generateFloors();
        generateClassrooms();
        generateDepartments();
        generateProfessors();
        generateStreams();
        generateGroups();
        generateStudents();
        generateSubjects();
        generateLectures();
        generateLectureGroups();
    }

    private void generateLectureGroups() {
        lectureGroupDao.save(new LectureGroup(1,1));
        lectureGroupDao.save(new LectureGroup(1,2));
        lectureGroupDao.save(new LectureGroup(2,1));
        lectureGroupDao.save(new LectureGroup(3,2));
        lectureGroupDao.save(new LectureGroup(3,1));
        lectureGroupDao.save(new LectureGroup(4,2));
    }

    private void generateLectures() {
        lectureDao.save(new Lecture(1, 1, LocalDate.of(2020, 10, 7), LocalTime.of(7, 45), 1));
        lectureDao.save(new Lecture(2, 2, LocalDate.of(2020, 10, 7), LocalTime.of(9, 30), 2));
        lectureDao.save(new Lecture(3, 3, LocalDate.of(2020, 10, 7), LocalTime.of(11, 15), 3));
        lectureDao.save(new Lecture(4, 4, LocalDate.of(2020, 10, 7), LocalTime.of(13, 10), 4));
        lectureDao.save(new Lecture(1, 1, LocalDate.of(2020, 10, 14), LocalTime.of(7, 45), 1));
        lectureDao.save(new Lecture(2, 2, LocalDate.of(2020, 10, 14), LocalTime.of(9, 30), 2));
        lectureDao.save(new Lecture(3, 3, LocalDate.of(2020, 10, 14), LocalTime.of(11, 15), 3));
        lectureDao.save(new Lecture(4, 4, LocalDate.of(2020, 10, 14), LocalTime.of(13, 10), 4));
        lectureDao.save(new Lecture(1, 1, LocalDate.of(2020, 10, 21), LocalTime.of(7, 45), 1));
        lectureDao.save(new Lecture(2, 2, LocalDate.of(2020, 10, 21), LocalTime.of(9, 30), 2));
        lectureDao.save(new Lecture(3, 3, LocalDate.of(2020, 10, 21), LocalTime.of(11, 15), 3));
        lectureDao.save(new Lecture(4, 4, LocalDate.of(2020, 10, 21), LocalTime.of(13, 10), 4));
    }

    private void generateSubjects() {
        subjectDao.save(new Subject("Math"));
        subjectDao.save(new Subject("Physics"));
        subjectDao.save(new Subject("History"));
        subjectDao.save(new Subject("Geography"));
    }

    private void generateStudents() {
        studentDao.save(new Student("James", 1));
        studentDao.save(new Student("Rose", 1));
        studentDao.save(new Student("Steven", 2));
        studentDao.save(new Student("Chris", 2));
    }

    private void generateGroups() {
        groupDao.save(new Group("M-1-1", 1));
        groupDao.save(new Group("H-1-1", 2));
    }

    private void generateStreams() {
        streamDao.save(new Stream("M-1", 1));
        streamDao.save(new Stream("H-1", 2));
    }

    private void generateProfessors() {
        professorDao.save(new Professor("Smith", 1));
        professorDao.save(new Professor("Stevenson", 1));
        professorDao.save(new Professor("Anderson", 2));
        professorDao.save(new Professor("Jackson", 2));
    }

    private void generateDepartments() {
        departmentDao.save(new Department("Math Department"));
        departmentDao.save(new Department("History Department"));
    }

    private void generateClassrooms() {
        classroomDao.save(new Classroom(12, 1));
        classroomDao.save(new Classroom(23, 2));
        classroomDao.save(new Classroom(34, 3));
        classroomDao.save(new Classroom(43, 4));
        classroomDao.save(new Classroom(51, 5));
        classroomDao.save(new Classroom(14, 5));
    }

    private void generateFloors() {
        floorDao.save(new Floor(1, 1));
        floorDao.save(new Floor(1, 2));
        floorDao.save(new Floor(2, 2));
        floorDao.save(new Floor(1, 3));
        floorDao.save(new Floor(2, 3));
        floorDao.save(new Floor(3, 3));
    }

    private void generateBuildings() {
        buildingDao.save(new Building("Building1", 1));
        buildingDao.save(new Building("Building2", 2));
        buildingDao.save(new Building("Building3", 3));
    }
}
