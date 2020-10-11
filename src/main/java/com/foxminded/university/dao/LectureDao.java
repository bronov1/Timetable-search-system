package com.foxminded.university.dao;

import com.foxminded.university.entity.Lecture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LectureDao implements Dao<Lecture>{

    private static final Logger logger = LoggerFactory.getLogger("LectureDao");

    private static final String GET_LECTURE = "SELECT * FROM LECTURES WHERE ID = ?";
    private static final String GET_ALL_LECTURES = "SELECT * FROM LECTURES";
    private static final String SAVE_LECTURE = "INSERT INTO LECTURES (SUBJECTID, PROFESSORID, DATE, TIME, CLASSROOMID) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_LECTURE = "UPDATE LECTURES SET (SUBJECTID, PROFESSORID, DATE, TIME, CLASSROOMID)  = (?, ?, ?, ?, ?) WHERE ID = ?";
    private static final String DELETE_LECTURE = "DELETE FROM LECTURES WHERE ID = ?";

    private final JdbcTemplate jdbcTemplate;

    public LectureDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Lecture get(int id) {
        Lecture lecture = jdbcTemplate.queryForObject(GET_LECTURE, new Object[]{id}, new BeanPropertyRowMapper<>(Lecture.class));
        logger.info("Объект {} взят из базы", lecture.getClass());
        return lecture;
    }

    @Override
    public List<Lecture> getAll() {
        List<Lecture> lectures = jdbcTemplate.query(GET_ALL_LECTURES, new BeanPropertyRowMapper<>(Lecture.class));
        logger.info("Список обектов {} взят из базы", lectures.getClass());
        return lectures;
    }

    @Override
    public void save(Lecture lecture) {
        jdbcTemplate.update(SAVE_LECTURE, lecture.getSubjectId(), lecture.getProfessorId(), lecture.getDate(), lecture.getTime(), lecture.getClassroomId());
        logger.info("Объект {} сохранен в базу", lecture.getClass());
    }

    @Override
    public void update(Lecture lecture, Object[] params) {
        jdbcTemplate.update(UPDATE_LECTURE, params[0], params[1], params[2], params[3], params[4], lecture.getId());
        logger.info("Объект {} обновлен", lecture.getClass());
    }

    @Override
    public void delete(Lecture lecture) {
        jdbcTemplate.update(DELETE_LECTURE, lecture.getId());
        logger.info("Объект {} удален из базы", lecture.getClass());
    }
}
