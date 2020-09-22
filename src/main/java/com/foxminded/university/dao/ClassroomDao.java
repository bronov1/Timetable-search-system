package com.foxminded.university.dao;

import com.foxminded.university.entity.Classroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ClassroomDao implements Dao<Classroom>{

    private static final String GET_CLASSROOM = "Select * from classrooms where id = ?";
    private static final String GET_ALL_CLASSROOMS = "Select * from classrooms";
    private static final String SAVE_CLASSROOM = "Insert into classrooms (number, floor) values (?,?)";
    private static final String UPDATE_CLASSROOM = "Update classrooms set (number, floor)  = (?, ?) where id = ?";
    private static final String DELETE_CLASSROOM = "Delete from classrooms where id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Classroom get(int id) {
        return jdbcTemplate.queryForObject(GET_CLASSROOM, new Object[]{id}, new BeanPropertyRowMapper<>(Classroom.class));
    }

    @Override
    public List<Classroom> getAll() {
        return jdbcTemplate.query(GET_ALL_CLASSROOMS, new BeanPropertyRowMapper<>(Classroom.class));
    }

    @Override
    public void save(Classroom classroom) {
        jdbcTemplate.update(SAVE_CLASSROOM, classroom.getNumber(), classroom.getFloor());
    }

    @Override
    public void update(Classroom classroom, Object[] params) {
        jdbcTemplate.update(UPDATE_CLASSROOM, params[0], params[1], classroom.getId());
    }

    @Override
    public void delete(Classroom classroom) {
        jdbcTemplate.update(DELETE_CLASSROOM, classroom.getId());
    }
}
