package com.foxminded.university.dao;

import com.foxminded.university.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDao implements Dao<Person> {

    private static final String GET_PERSON = "SELECT * FROM PERSONS WHERE ID = ?";
    private static final String GET_ALL_PERSONS = "SELECT * FROM PERSONS";
    private static final String SAVE_PERSON = "INSERT INTO PERSONS (NAME) VALUES (?)";
    private static final String UPDATE_PERSON = "UPDATE PERSONS SET (NAME)  = (?) WHERE ID = ?";
    private static final String DELETE_PERSON = "DELETE FROM PERSONS WHERE ID = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public Person get(int id) {
        return jdbcTemplate.queryForObject(GET_PERSON, new Object[]{id}, new BeanPropertyRowMapper<>(Person.class));
    }

    @Override
    public List<Person> getAll() {
        return jdbcTemplate.query(GET_ALL_PERSONS, new BeanPropertyRowMapper<>(Person.class));
    }

    @Override
    public void save(Person person) {
        jdbcTemplate.update(SAVE_PERSON, person.getName());
    }

    @Override
    public void update(Person person, Object[] params) {
        jdbcTemplate.update(UPDATE_PERSON, params[0], person.getId());
    }

    @Override
    public void delete(Person person) {
        jdbcTemplate.update(DELETE_PERSON, person.getId());
    }
}
