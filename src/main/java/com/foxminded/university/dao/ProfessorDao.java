package com.foxminded.university.dao;

import com.foxminded.university.entity.Lecture;
import com.foxminded.university.entity.Professor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class ProfessorDao implements Dao<Professor>{

    private static final String GET_PROFESSOR = "SELECT * FROM PROFESSORS WHERE ID = ?";
    private static final String GET_ALL_PROFESSORS = "SELECT * FROM PROFESSORS";
    private static final String SAVE_PROFESSOR = "INSERT INTO PROFESSORS (NAME, DEPARTMENTID) VALUES (?,?)";
    private static final String UPDATE_PROFESSOR = "UPDATE PROFESSORS SET (NAME, DEPARTMENTID)  = (?, ?) WHERE ID = ?";
    private static final String DELETE_PROFESSOR = "DELETE FROM PROFESSORS WHERE ID = ?";
    private static final String GET_PROFESSOR_PERIOD_SCHEDULE = "SELECT * FROM LECTURES " +
            "WHERE PROFESSORID = ? AND DATE BETWEEN ? AND ?";

    private final JdbcTemplate jdbcTemplate;

    public ProfessorDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

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
        jdbcTemplate.update(SAVE_PROFESSOR, professor.getName(), professor.getDepartmentId());
    }

    @Override
    public void update(Professor professor, Object[] params) {
        jdbcTemplate.update(UPDATE_PROFESSOR, params[0], params[1], professor.getId());
    }

    @Override
    public void delete(Professor professor) {
        jdbcTemplate.update(DELETE_PROFESSOR, professor.getId());
    }

    public List<Lecture> getProfessorPeriodLectures(int professorId, LocalDate startDate, LocalDate finishDate) {
        return jdbcTemplate.query(GET_PROFESSOR_PERIOD_SCHEDULE, new BeanPropertyRowMapper<>(Lecture.class), professorId, startDate, finishDate);
    }
}
