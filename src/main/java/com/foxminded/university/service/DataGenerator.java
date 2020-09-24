package com.foxminded.university.service;

import com.foxminded.university.dao.*;
import com.foxminded.university.entity.*;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;

@Component
public class DataGenerator {

    public void createTables(ApplicationContext context) throws URISyntaxException, IOException {
        Path scriptPath = context.getBean(FileReader.class).getFilePath("createTables.sql");
        context.getBean(ScriptRunner.class).executeScript(scriptPath);
        generateData(context);
    }

    public void generateData(ApplicationContext context){
        generateBuildings(context);
        generateFloors(context);
        generateClassrooms(context);
        generateDepartments(context);
        generateProfessors(context);
    }

    private void generateProfessors(ApplicationContext context) {
        ProfessorDao professorDao = context.getBean(ProfessorDao.class);
        professorDao.save(new Professor("Smith", 1));
        professorDao.save(new Professor("Stivenson", 1));
        professorDao.save(new Professor("Anderson", 2));
        professorDao.save(new Professor("Jackson", 2));
    }

    private void generateDepartments(ApplicationContext context) {
        DepartmentDao departmentDao = context.getBean(DepartmentDao.class);
        departmentDao.save(new Department("Math Department"));
        departmentDao.save(new Department("History Department"));
    }

    private void generateClassrooms(ApplicationContext context) {
        ClassroomDao classroomDao = context.getBean(ClassroomDao.class);
        classroomDao.save(new Classroom(12,1));
        classroomDao.save(new Classroom(23,2));
        classroomDao.save(new Classroom(34,3));
        classroomDao.save(new Classroom(43,4));
        classroomDao.save(new Classroom(51,5));
        classroomDao.save(new Classroom(14,5));
    }

    private void generateFloors(ApplicationContext context) {
        FloorDao floorDao = context.getBean(FloorDao.class);
        floorDao.save(new Floor(1,1));
        floorDao.save(new Floor(1,2));
        floorDao.save(new Floor(2,2));
        floorDao.save(new Floor(1,3));
        floorDao.save(new Floor(2,3));
        floorDao.save(new Floor(3,3));
    }

    private void generateBuildings(ApplicationContext context) {
        BuildingDao buildingDao = context.getBean(BuildingDao.class);
        buildingDao.save(new Building("Building1", 1));
        buildingDao.save(new Building("Building2", 2));
        buildingDao.save(new Building("Building3", 3));
    }
}
