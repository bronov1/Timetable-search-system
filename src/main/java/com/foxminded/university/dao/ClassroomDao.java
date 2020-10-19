package com.foxminded.university.dao;

import com.foxminded.university.entity.Classroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClassroomDao implements Dao<Classroom>{

    private static final String GET_CLASSROOM = "SELECT * FROM CLASSROOMS WHERE ID = ?";
    private static final String GET_ALL_CLASSROOMS = "SELECT * FROM CLASSROOMS";
    private static final String SAVE_CLASSROOM = "INSERT INTO CLASSROOMS (NUMBER, FLOORID) VALUES (?,?)";
    private static final String UPDATE_CLASSROOM = "UPDATE CLASSROOMS SET (NUMBER, FLOORID)  = (?, ?) WHERE ID = ?";
    private static final String DELETE_CLASSROOM = "DELETE FROM CLASSROOMS WHERE ID = ?";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ClassroomDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

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
        jdbcTemplate.update(SAVE_CLASSROOM, classroom.getNumber(), classroom.getFloorId());
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
