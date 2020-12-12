package com.foxminded.university.dao;

import com.foxminded.university.entity.Group;
import com.foxminded.university.entity.Lecture;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class GroupDao implements Dao<Group>{

    private static final String GET_GROUP = "SELECT * FROM GROUPS WHERE ID = ?";
    private static final String GET_ALL_GROUPS = "SELECT * FROM GROUPS";
    private static final String SAVE_GROUP = "INSERT INTO GROUPS (NAME, STREAMID) VALUES (?,?)";
    private static final String UPDATE_GROUP = "UPDATE GROUPS SET (NAME, STREAMID)  = (?, ?) WHERE ID = ?";
    private static final String DELETE_GROUP = "DELETE FROM GROUPS WHERE ID = ?";
    private static final String GET_ALL_GROUPS_FOR_LECTURE = "SELECT * FROM GROUPS " +
            "INNER JOIN LECTUREGROUPS ON GROUPS.ID = LECTUREGROUPS.GROUPID " +
            "WHERE LECTUREID = ?";
    private static final String GET_GROUP_PERIOD_SCHEDULE = "SELECT * FROM GROUPS " +
            "INNER JOIN LECTUREGROUPS ON GROUPS.ID = LECTUREGROUPS.GROUPID " +
            "INNER JOIN LECTURES ON LECTURES.ID = LECTUREGROUPS.LECTUREID " +
            "WHERE GROUPID = ? AND DATE BETWEEN ? AND ?";

    private final JdbcTemplate jdbcTemplate;
    private final StudentDao studentDao;
    private final LectureGroupDao lectureGroupDao;

    public GroupDao(JdbcTemplate jdbcTemplate, StudentDao studentDao, LectureGroupDao lectureGroupDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.studentDao = studentDao;
        this.lectureGroupDao = lectureGroupDao;
    }

    @Override
    public Group get(int id) {
        return jdbcTemplate.queryForObject(GET_GROUP, new Object[]{id}, new BeanPropertyRowMapper<>(Group.class));
    }

    @Override
    public List<Group> getAll() {
        return jdbcTemplate.query(GET_ALL_GROUPS, new BeanPropertyRowMapper<>(Group.class));

    }

    @Override
    public void save(Group group) {
        jdbcTemplate.update(SAVE_GROUP, group.getName(), group.getStreamId());
    }

    @Override
    public void update(Group group, Object[] params) {
        jdbcTemplate.update(UPDATE_GROUP, params[0], params[1], group.getId());
    }

    @Override
    public void delete(Group group) {
        studentDao.DeleteStudentsFromGroup(group);
        lectureGroupDao.DeleteGroupFromLecture(group);
        jdbcTemplate.update(DELETE_GROUP, group.getId());
    }

    public List<Lecture> getGroupPeriodLectures(int groupId, LocalDate startDate, LocalDate finishDate) {
        return jdbcTemplate.query(GET_GROUP_PERIOD_SCHEDULE, new BeanPropertyRowMapper<>(Lecture.class), groupId, startDate, finishDate);
    }

    public List<Group> getGroupsOnLecture(int lectureId) {
        return jdbcTemplate.query(GET_ALL_GROUPS_FOR_LECTURE, new BeanPropertyRowMapper<>(Group.class), lectureId);
    }
}
