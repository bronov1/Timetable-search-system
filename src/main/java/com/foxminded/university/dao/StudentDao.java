package com.foxminded.university.dao;

import com.foxminded.university.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDao implements Dao<Student> {

    private static final Logger logger = LoggerFactory.getLogger("StudentDao");

    private static final String GET_STUDENT = "SELECT * FROM STUDENTS WHERE ID = ?";
    private static final String GET_ALL_STUDENTS = "SELECT * FROM STUDENTS";
    private static final String SAVE_STUDENT = "INSERT INTO STUDENTS (NAME, GROUPID) VALUES (?,?)";
    private static final String UPDATE_STUDENT = "UPDATE STUDENTS SET (NAME, GROUPID)  = (?, ?) WHERE ID = ?";
    private static final String DELETE_STUDENT = "DELETE FROM STUDENTS WHERE ID = ?";

    private final JdbcTemplate jdbcTemplate;

    public StudentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Student get(int id) {
        Student student = jdbcTemplate.queryForObject(GET_STUDENT, new Object[]{id}, new BeanPropertyRowMapper<>(Student.class));
        logger.info("Объект {} взят из базы", student.getClass());
        return student;
    }

    @Override
    public List<Student> getAll() {
        List<Student> students = jdbcTemplate.query(GET_ALL_STUDENTS, new BeanPropertyRowMapper<>(Student.class));
        logger.info("Список обектов {} взят из базы", students.getClass());
        return students;
    }

    @Override
    public void save(Student student) {
        jdbcTemplate.update(SAVE_STUDENT, student.getName(), student.getGroupId());
        logger.info("Объект {} сохранен в базу", student.getClass());
    }

    @Override
    public void update(Student student, Object[] params) {
        jdbcTemplate.update(UPDATE_STUDENT, params[0], params[1], student.getId());
        logger.info("Объект {} обновлен", student.getClass());
    }

    @Override
    public void delete(Student student) {
        jdbcTemplate.update(DELETE_STUDENT, student.getId());
        logger.info("Объект {} удален из базы", student.getClass());
    }
}
