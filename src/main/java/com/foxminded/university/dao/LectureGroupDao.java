package com.foxminded.university.dao;

import com.foxminded.university.entity.Lecture;
import com.foxminded.university.entity.LectureGroup;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LectureGroupDao implements Dao<LectureGroup> {

    private static final String GET_LECTURE_GROUP = "SELECT * FROM LECTUREGROUPS WHERE ID = ?";
    private static final String GET_ALL_LECTURE_GROUP = "SELECT * FROM LECTUREGROUPS";
    private static final String SAVE_LECTURE_GROUP = "INSERT INTO LECTUREGROUPS (LECTUREID, GROUPID) VALUES (?,?)";
    private static final String UPDATE_LECTURE_GROUP = "UPDATE LECTUREGROUPS SET (LECTUREID, GROUPID)  = (?, ?) WHERE ID = ?";
    private static final String DELETE_LECTURE_GROUP = "DELETE FROM LECTUREGROUPS WHERE ID = ?";
    private static final String DELETE_LECTURE_FOR_GROUPS = "DELETE FROM LECTUREGROUPS WHERE LECTUREID = ?";

    private final JdbcTemplate jdbcTemplate;

    public LectureGroupDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public LectureGroup get(int id) {
        return jdbcTemplate.queryForObject(GET_LECTURE_GROUP, new Object[]{id}, new BeanPropertyRowMapper<>(LectureGroup.class));
    }

    @Override
    public List<LectureGroup> getAll() {
        return jdbcTemplate.query(GET_ALL_LECTURE_GROUP, new BeanPropertyRowMapper<>(LectureGroup.class));
    }

    @Override
    public void save(LectureGroup lectureGroup) {
        jdbcTemplate.update(SAVE_LECTURE_GROUP, lectureGroup.getLectureId(), lectureGroup.getGroupId());
    }

    @Override
    public void update(LectureGroup lectureGroup, Object[] params) {
        jdbcTemplate.update(UPDATE_LECTURE_GROUP, params[0], params[1], lectureGroup.getId());
    }

    @Override
    public void delete(LectureGroup lectureGroup) {
        jdbcTemplate.update(DELETE_LECTURE_GROUP, lectureGroup.getId());
    }

    public void deleteGroupsFromLecture(Lecture lecture) {
        jdbcTemplate.update(DELETE_LECTURE_FOR_GROUPS, lecture.getId());
    }
}
