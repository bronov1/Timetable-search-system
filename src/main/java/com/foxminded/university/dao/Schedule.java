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

    private static final String GET_GROUP_DAY_SCHEDULE = "SELECT * FROM LECTURES " +
            "INNER JOIN LECTUREGROUPS ON LECTURES.ID = LECTUREGROUPS.LECTUREID " +
            "INNER JOIN GROUPS ON GROUPS.ID = LECTUREGROUPS.GROUPID " +
            "WHERE GROUPID = ? AND DATE = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Lecture> getGroupDayLectures(int groupId, LocalDate date) {
        return jdbcTemplate.query(GET_GROUP_DAY_SCHEDULE, new BeanPropertyRowMapper<>(Lecture.class), groupId, date);
    }
}
