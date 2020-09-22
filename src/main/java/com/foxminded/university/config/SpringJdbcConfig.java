package com.foxminded.university.config;

import com.foxminded.university.dao.*;
import com.foxminded.university.entity.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.foxminded.university")
public class SpringJdbcConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://127.0.0.1:5432/university");
        dataSource.setUsername("maintainer");
        dataSource.setPassword("12345678");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public Building building() {
        return new Building();
    }

    @Bean
    public BuildingDao buildingDao() {
        return new BuildingDao();
    }

    @Bean
    public Classroom classroom() {
        return new Classroom();
    }

    @Bean
    public ClassroomDao classroomDao() {
        return new ClassroomDao();
    }

    @Bean
    public Department department() {
        return new Department();
    }

    @Bean
    public DepartmentDao departmentDao() {
        return new DepartmentDao();
    }

    @Bean
    public Floor floor() {
        return new Floor();
    }

    @Bean
    public FloorDao floorDao() {
        return new FloorDao();
    }

    @Bean
    public Group group() {
        return new Group();
    }

    @Bean
    public GroupDao groupDao() {
        return new GroupDao();
    }

    @Bean
    public Lecture lecture() {
        return new Lecture();
    }

    @Bean
    public LectureDao lectureDao() {
        return new LectureDao();
    }

    @Bean
    public Person person() {
        return new Person();
    }

    @Bean
    public PersonDao personDao() {
        return new PersonDao();
    }

    @Bean
    public Professor professor() {
        return new Professor();
    }

    @Bean
    public ProfessorDao professorDao() {
        return new ProfessorDao();
    }

    @Bean
    public Stream stream() {
        return new Stream();
    }

    @Bean
    public StreamDao streamDao() {
        return new StreamDao();
    }

    @Bean
    public Student student() {
        return new Student();
    }

    @Bean
    public StudentDao studentDao() {
        return new StudentDao();
    }

    @Bean
    public Subject subject() {
        return new Subject();
    }

    @Bean
    public SubjectDao subjectDao() {
        return new SubjectDao();
    }

    @Bean
    public LectureGroupDao lectureGroupDao() {
        return new LectureGroupDao();
    }

    @Bean
    public LectureGroup lectureGroup() {
        return new LectureGroup();
    }
}
