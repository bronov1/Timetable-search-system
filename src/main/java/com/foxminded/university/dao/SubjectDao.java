package com.foxminded.university.dao;


import com.foxminded.university.entity.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubjectDao implements Dao<Subject> {

    private static final Logger logger = LoggerFactory.getLogger("SubjectDao");

    private static final String GET_SUBJECT = "SELECT * FROM SUBJECTS WHERE ID = ?";
    private static final String GET_ALL_SUBJECTS = "SELECT * FROM SUBJECTS";
    private static final String SAVE_SUBJECT = "INSERT INTO SUBJECTS (NAME) VALUES (?)";
    private static final String UPDATE_SUBJECT = "UPDATE SUBJECTS SET NAME  = ? WHERE ID = ?";
    private static final String DELETE_SUBJECT = "DELETE FROM SUBJECTS WHERE ID = ?";

    private final JdbcTemplate jdbcTemplate;

    public SubjectDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Subject get(int id) {
        Subject subject = jdbcTemplate.queryForObject(GET_SUBJECT, new Object[]{id}, new BeanPropertyRowMapper<>(Subject.class));
        logger.info("Объект {} взят из базы", subject.getClass());
        return subject;
    }

    @Override
    public List<Subject> getAll() {
        List<Subject> subjects = jdbcTemplate.query(GET_ALL_SUBJECTS, new BeanPropertyRowMapper<>(Subject.class));
        logger.info("Список обектов {} взят из базы", subjects.getClass());
        return subjects;
    }

    @Override
    public void save(Subject subject) {
        jdbcTemplate.update(SAVE_SUBJECT, subject.getName());
        logger.info("Объект {} сохранен в базу", subject.getClass());
    }

    @Override
    public void update(Subject subject, Object[] params) {
        jdbcTemplate.update(UPDATE_SUBJECT, params[0], subject.getId());
        logger.info("Объект {} обновлен", subject.getClass());
    }

    @Override
    public void delete(Subject subject) {
        jdbcTemplate.update(DELETE_SUBJECT, subject.getId());
        logger.info("Объект {} удален из базы", subject.getClass());
    }
}

