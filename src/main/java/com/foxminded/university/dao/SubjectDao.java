package com.foxminded.university.dao;


import com.foxminded.university.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubjectDao implements Dao<Subject> {

    private static final String GET_SUBJECT = "SELECT * FROM SUBJECTS WHERE ID = ?";
    private static final String GET_ALL_SUBJECTS = "SELECT * FROM SUBJECTS";
    private static final String SAVE_SUBJECT = "INSERT INTO SUBJECTS (NAME) VALUES (?)";
    private static final String UPDATE_SUBJECT = "UPDATE SUBJECTS SET NAME  = ? WHERE ID = ?";
    private static final String DELETE_SUBJECT = "DELETE FROM SUBJECTS WHERE ID = ?";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SubjectDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Subject get(int id) {
        return jdbcTemplate.queryForObject(GET_SUBJECT, new Object[]{id}, new BeanPropertyRowMapper<>(Subject.class));
    }

    @Override
    public List<Subject> getAll() {
        return jdbcTemplate.query(GET_ALL_SUBJECTS, new BeanPropertyRowMapper<>(Subject.class));
    }

    @Override
    public void save(Subject subject) {
        jdbcTemplate.update(SAVE_SUBJECT, subject.getName());
    }

    @Override
    public void update(Subject subject, Object[] params) {
        jdbcTemplate.update(UPDATE_SUBJECT, params[0], subject.getId());
    }

    @Override
    public void delete(Subject subject) {
        jdbcTemplate.update(DELETE_SUBJECT, subject.getId());
    }
}

