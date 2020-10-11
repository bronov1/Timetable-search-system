package com.foxminded.university.dao;

import com.foxminded.university.entity.LectureGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LectureGroupDao implements Dao<LectureGroup> {

    private static final Logger logger = LoggerFactory.getLogger("LectureGroupDao");

    private static final String GET_LECTURE_GROUP = "SELECT * FROM LECTUREGROUPS WHERE ID = ?";
    private static final String GET_ALL_LECTURE_GROUP = "SELECT * FROM LECTUREGROUPS";
    private static final String SAVE_LECTURE_GROUP = "INSERT INTO LECTUREGROUPS (LECTUREID, GROUPID) VALUES (?,?)";
    private static final String UPDATE_LECTURE_GROUP = "UPDATE LECTUREGROUPS SET (LECTUREID, GROUPID)  = (?, ?) WHERE ID = ?";
    private static final String DELETE_LECTURE_GROUP = "DELETE FROM LECTUREGROUPS WHERE ID = ?";

    private final JdbcTemplate jdbcTemplate;

    public LectureGroupDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public LectureGroup get(int id) {
        LectureGroup lectureGroup = jdbcTemplate.queryForObject(GET_LECTURE_GROUP, new Object[]{id}, new BeanPropertyRowMapper<>(LectureGroup.class));
        logger.info("Объект {} взят из базы", lectureGroup.getClass());
        return lectureGroup;
    }

    @Override
    public List<LectureGroup> getAll() {
        List<LectureGroup> lectureGroups = jdbcTemplate.query(GET_ALL_LECTURE_GROUP, new BeanPropertyRowMapper<>(LectureGroup.class));
        logger.info("Список обектов {} взят из базы", lectureGroups.getClass());
        return lectureGroups;
    }

    @Override
    public void save(LectureGroup lectureGroup) {
        jdbcTemplate.update(SAVE_LECTURE_GROUP, lectureGroup.getLectureId(), lectureGroup.getGroupId());
        logger.info("Объект {} сохранен в базу", lectureGroup.getClass());
    }

    @Override
    public void update(LectureGroup lectureGroup, Object[] params) {
        jdbcTemplate.update(UPDATE_LECTURE_GROUP, params[0], params[1], lectureGroup.getId());
        logger.info("Объект {} обновлен", lectureGroup.getClass());
    }

    @Override
    public void delete(LectureGroup lectureGroup) {
        jdbcTemplate.update(DELETE_LECTURE_GROUP, lectureGroup.getId());
        logger.info("Объект {} удален из базы", lectureGroup.getClass());
    }
}
