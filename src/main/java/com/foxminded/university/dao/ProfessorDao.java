package com.foxminded.university.dao;

import com.foxminded.university.entity.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProfessorDao implements Dao<Professor>{

    private static final String GET_PROFESSOR = "Select * from professors where id = ?";
    private static final String GET_ALL_PROFESSORS = "Select * from professors";
    private static final String SAVE_PROFESSOR = "Insert into professors (name, department) values (?,?)";
    private static final String UPDATE_PROFESSOR = "Update professors set (name, department)  = (?, ?) where id = ?";
    private static final String DELETE_PROFESSOR = "Delete from professors where id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Professor get(int id) {
        return jdbcTemplate.queryForObject(GET_PROFESSOR, new Object[]{id}, new BeanPropertyRowMapper<>(Professor.class));
    }

    @Override
    public List<Professor> getAll() {
        return jdbcTemplate.query(GET_ALL_PROFESSORS, new BeanPropertyRowMapper<>(Professor.class));
    }

    @Override
    public void save(Professor professor) {
        jdbcTemplate.update(SAVE_PROFESSOR, professor.getName(), professor.getDepartment());
    }

    @Override
    public void update(Professor professor, Object[] params) {
        jdbcTemplate.update(UPDATE_PROFESSOR, params[0], params[1], professor.getId());
    }

    @Override
    public void delete(Professor professor) {
        jdbcTemplate.update(DELETE_PROFESSOR, professor.getId());
    }
}
