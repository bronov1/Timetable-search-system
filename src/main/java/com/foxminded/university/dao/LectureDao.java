package com.foxminded.university.dao;

import com.foxminded.university.entity.Lecture;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LectureDao implements Dao<Lecture>{

    private static final String GET_LECTURE = "SELECT * FROM LECTURES WHERE ID = ?";
    private static final String GET_ALL_LECTURES = "SELECT * FROM LECTURES";
    private static final String SAVE_LECTURE = "INSERT INTO LECTURES (SUBJECTID, PROFESSORID, DATE, TIME, CLASSROOMID) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_LECTURE = "UPDATE LECTURES SET (SUBJECTID, PROFESSORID, DATE, TIME, CLASSROOMID)  = (?, ?, ?, ?, ?) WHERE ID = ?";
    private static final String DELETE_LECTURE = "DELETE FROM LECTURES WHERE ID = ?";

    private final JdbcTemplate jdbcTemplate;
    private final LectureGroupDao lectureGroupDao;

    public LectureDao(JdbcTemplate jdbcTemplate, LectureGroupDao lectureGroupDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.lectureGroupDao = lectureGroupDao;
    }

    @Override
    public Lecture get(int id) {
        return jdbcTemplate.queryForObject(GET_LECTURE, new Object[]{id}, new BeanPropertyRowMapper<>(Lecture.class));
    }

    @Override
    public List<Lecture> getAll() {
        return jdbcTemplate.query(GET_ALL_LECTURES, new BeanPropertyRowMapper<>(Lecture.class));
    }

    @Override
    public void save(Lecture lecture) {
        jdbcTemplate.update(SAVE_LECTURE, lecture.getSubjectId(), lecture.getProfessorId(), lecture.getDate(), lecture.getTime(), lecture.getClassroomId());
    }

    @Override
    public void update(Lecture lecture, Object[] params) {
        jdbcTemplate.update(UPDATE_LECTURE, params[0], params[1], params[2], params[3], params[4], lecture.getId());
    }

    @Override
    public void delete(Lecture lecture) {
        lectureGroupDao.deleteGroupsFromLecture(lecture);
        jdbcTemplate.update(DELETE_LECTURE, lecture.getId());
    }
}
