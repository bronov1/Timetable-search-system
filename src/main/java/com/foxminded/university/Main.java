package com.foxminded.university;

import com.foxminded.university.config.SpringJdbcConfig;
import com.foxminded.university.dao.BuildingDao;
import com.foxminded.university.entity.Building;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringJdbcConfig.class);
        BuildingDao buildingDao = context.getBean(BuildingDao.class);
        List<Building> buildings = buildingDao.getAll();
        buildings.forEach(System.out::println);
    }
}
