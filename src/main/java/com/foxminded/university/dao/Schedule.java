package com.foxminded.university.dao;

import com.foxminded.university.entity.Lecture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class Schedule {

    private static final String GET_GROUP_DAY_SCHEDULE = "SELECT * FROM GROUPS " +
            "INNER JOIN LECTUREGROUPS ON GROUPS.ID = LECTUREGROUPS.GROUPID " +
            "INNER JOIN LECTURES ON LECTURES.ID = LECTUREGROUPS.LECTUREID " +
            "WHERE LECTUREGROUPS.GROUPID = ? AND LECTURES.DATE = ?";
    private static final String GET_GROUP_PERIOD_SCHEDULE = "SELECT * FROM GROUPS " +
            "INNER JOIN LECTUREGROUPS ON GROUPS.ID = LECTUREGROUPS.GROUPID " +
            "INNER JOIN LECTURES ON LECTURES.ID = LECTUREGROUPS.LECTUREID " +
            "WHERE GROUPID = ? AND DATE BETWEEN ? AND ?";
    private static final String GET_PROFESSOR_DAY_SCHEDULE = "SELECT * FROM LECTURES " +
            "WHERE PROFESSORID = ? AND DATE = ?";
    private static final String GET_PROFESSOR_PERIOD_SCHEDULE = "SELECT * FROM LECTURES " +
            "WHERE PROFESSORID = ? AND DATE BETWEEN ? AND ?";


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Lecture> getGroupDayLectures(int groupId, LocalDate date) {
        return jdbcTemplate.query(GET_GROUP_DAY_SCHEDULE, new BeanPropertyRowMapper<>(Lecture.class), groupId, date);
    }

    public List<Lecture> getGroupMonthLectures(int groupId, LocalDate startDate, LocalDate finishDate) {
        return jdbcTemplate.query(GET_GROUP_PERIOD_SCHEDULE, new BeanPropertyRowMapper<>(Lecture.class), groupId, startDate, finishDate);
    }

    public List<Lecture> getProfessorDayLectures(int professorId, LocalDate date) {
        return jdbcTemplate.query(GET_PROFESSOR_DAY_SCHEDULE, new BeanPropertyRowMapper<>(Lecture.class), professorId, date);
    }

    public List<Lecture> getProfessorMonthLectures(int professorId, LocalDate startDate, LocalDate finishDate) {
        return jdbcTemplate.query(GET_PROFESSOR_PERIOD_SCHEDULE, new BeanPropertyRowMapper<>(Lecture.class), professorId, startDate, finishDate);
    }
}
