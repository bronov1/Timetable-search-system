package com.foxminded.university.service;

import com.foxminded.university.dao.*;
import com.foxminded.university.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;

@Service
public class DataGenerator {

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

    public void generateData(){
        generateBuildings();
        generateFloors();
        generateClassrooms();
        generateDepartments();
        generateProfessors();
    }

    private void generateProfessors() {
        professorDao.save(new Professor("Smith", 1));
        professorDao.save(new Professor("Stivenson", 1));
        professorDao.save(new Professor("Anderson", 2));
        professorDao.save(new Professor("Jackson", 2));
    }

    private void generateDepartments() {
        departmentDao.save(new Department("Math Department"));
        departmentDao.save(new Department("History Department"));
    }

    private void generateClassrooms() {
        classroomDao.save(new Classroom(12,1));
        classroomDao.save(new Classroom(23,2));
        classroomDao.save(new Classroom(34,3));
        classroomDao.save(new Classroom(43,4));
        classroomDao.save(new Classroom(51,5));
        classroomDao.save(new Classroom(14,5));
    }

    private void generateFloors() {
        floorDao.save(new Floor(1,1));
        floorDao.save(new Floor(1,2));
        floorDao.save(new Floor(2,2));
        floorDao.save(new Floor(1,3));
        floorDao.save(new Floor(2,3));
        floorDao.save(new Floor(3,3));
    }

    private void generateBuildings() {
        buildingDao.save(new Building("Building1", 1));
        buildingDao.save(new Building("Building2", 2));
        buildingDao.save(new Building("Building3", 3));
    }
}
