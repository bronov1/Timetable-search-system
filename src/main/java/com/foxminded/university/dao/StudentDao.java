package com.foxminded.university.dao;

import com.foxminded.university.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDao implements Dao<Student> {

    private static final String GET_STUDENT = "SELECT * FROM STUDENTS WHERE ID = ?";
    private static final String GET_ALL_STUDENTS = "SELECT * FROM STUDENTS";
    private static final String SAVE_STUDENT = "INSERT INTO STUDENTS (NAME, GROUPID) VALUES (?,?)";
    private static final String UPDATE_STUDENT = "UPDATE STUDENTS SET (NAME, GROUPID)  = (?, ?) WHERE ID = ?";
    private static final String DELETE_STUDENT = "DELETE FROM STUDENTS WHERE ID = ?";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Student get(int id) {
        return jdbcTemplate.queryForObject(GET_STUDENT, new Object[]{id}, new BeanPropertyRowMapper<>(Student.class));
    }

    @Override
    public List<Student> getAll() {
        return jdbcTemplate.query(GET_ALL_STUDENTS, new BeanPropertyRowMapper<>(Student.class));
    }

    @Override
    public void save(Student student) {
        jdbcTemplate.update(SAVE_STUDENT, student.getName(), student.getGroupId());
    }

    @Override
    public void update(Student student, Object[] params) {
        jdbcTemplate.update(UPDATE_STUDENT, params[0], params[1], student.getId());
    }

    @Override
    public void delete(Student student) {
        jdbcTemplate.update(DELETE_STUDENT, student.getId());
    }
}
