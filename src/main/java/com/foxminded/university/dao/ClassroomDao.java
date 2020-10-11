package com.foxminded.university.dao;

import com.foxminded.university.entity.Classroom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClassroomDao implements Dao<Classroom>{

    private static final Logger logger = LoggerFactory.getLogger("ClassroomDao");

    private static final String GET_CLASSROOM = "SELECT * FROM CLASSROOMS WHERE ID = ?";
    private static final String GET_ALL_CLASSROOMS = "SELECT * FROM CLASSROOMS";
    private static final String SAVE_CLASSROOM = "INSERT INTO CLASSROOMS (NUMBER, FLOORID) VALUES (?,?)";
    private static final String UPDATE_CLASSROOM = "UPDATE CLASSROOMS SET (NUMBER, FLOORID)  = (?, ?) WHERE ID = ?";
    private static final String DELETE_CLASSROOM = "DELETE FROM CLASSROOMS WHERE ID = ?";

    private final JdbcTemplate jdbcTemplate;

    public ClassroomDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Classroom get(int id) {
        Classroom classroom = jdbcTemplate.queryForObject(GET_CLASSROOM, new Object[]{id}, new BeanPropertyRowMapper<>(Classroom.class));
        logger.info("Объект {} взят из базы", classroom.getClass());
        return classroom;
    }

    @Override
    public List<Classroom> getAll() {
        List<Classroom> classrooms = jdbcTemplate.query(GET_ALL_CLASSROOMS, new BeanPropertyRowMapper<>(Classroom.class));
        logger.info("Список обектов {} взят из базы", classrooms.getClass());
        return classrooms;
    }

    @Override
    public void save(Classroom classroom) {
        jdbcTemplate.update(SAVE_CLASSROOM, classroom.getNumber(), classroom.getFloorId());
        logger.info("Объект {} сохранен в базу", classroom.getClass());
    }

    @Override
    public void update(Classroom classroom, Object[] params) {
        jdbcTemplate.update(UPDATE_CLASSROOM, params[0], params[1], classroom.getId());
        logger.info("Объект {} обновлен", classroom.getClass());
    }

    @Override
    public void delete(Classroom classroom) {
        jdbcTemplate.update(DELETE_CLASSROOM, classroom.getId());
        logger.info("Объект {} удален из базы", classroom.getClass());
    }
}
