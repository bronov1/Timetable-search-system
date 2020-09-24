package com.foxminded.university;

import com.foxminded.university.config.SpringJdbcConfig;
import com.foxminded.university.dao.BuildingDao;
import com.foxminded.university.dao.ProfessorDao;
import com.foxminded.university.entity.Building;
import com.foxminded.university.entity.Professor;
import com.foxminded.university.service.DataGenerator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringJdbcConfig.class);
        DataGenerator dataGenerator = context.getBean(DataGenerator.class);
        dataGenerator.createTables(context);
        BuildingDao buildingDao = context.getBean(BuildingDao.class);
        List<Building> buildings = buildingDao.getAll();
        buildings.forEach(System.out::println);
        ProfessorDao professorDao = context.getBean(ProfessorDao.class);
        List<Professor> professors = professorDao.getAll();
        int startLength = professors.size();
        Professor professor = new Professor("Piper", 1);
        professorDao.save(professor);
        professors = professorDao.getAll();
        System.out.println(startLength + 1 == professors.size());
        professor.setId(5);
        professorDao.delete(professor);
        professors = professorDao.getAll();
        System.out.println(startLength == professors.size());
        professor = professorDao.get(1);
        System.out.println(professor);
        professorDao.update(professor, new Object[]{"Glen", 2});
        System.out.println(professor);
    }
}
