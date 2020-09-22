package com.foxminded.university.dao;

import com.foxminded.university.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class StudentDao implements Dao<Student> {

    private static final String GET_STUDENT = "Select * from students where id = ?";
    private static final String GET_ALL_STUDENTS = "Select * from students";
    private static final String SAVE_STUDENT = "Insert into students (name, group) values (?,?)";
    private static final String UPDATE_STUDENT = "Update students set (name, group)  = (?, ?) where id = ?";
    private static final String DELETE_STUDENT = "Delete from students where id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

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
        jdbcTemplate.update(SAVE_STUDENT, student.getName(), student.getGroup());
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
