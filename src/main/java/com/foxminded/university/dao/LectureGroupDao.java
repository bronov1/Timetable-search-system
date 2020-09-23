package com.foxminded.university.dao;

import com.foxminded.university.entity.LectureGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LectureGroupDao implements Dao<LectureGroup> {

    private static final String GET_LECTURE_GROUP = "Select * from lecture_group where id = ?";
    private static final String GET_ALL_LECTURE_GROUP = "Select * from lecture_group";
    private static final String SAVE_LECTURE_GROUP = "Insert into lecture_group (lectureId, groupId) values (?,?)";
    private static final String UPDATE_LECTURE_GROUP = "Update lecture_group set (lectureId, groupId)  = (?, ?) where id = ?";
    private static final String DELETE_LECTURE_GROUP = "Delete from lecture_group where id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

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
}
