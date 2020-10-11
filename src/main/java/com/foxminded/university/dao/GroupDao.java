package com.foxminded.university.dao;

import com.foxminded.university.entity.Group;
import com.foxminded.university.entity.Lecture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class GroupDao implements Dao<Group>{

    private static final Logger logger = LoggerFactory.getLogger("GroupDao");

    private static final String GET_GROUP = "SELECT * FROM GROUPS WHERE ID = ?";
    private static final String GET_ALL_GROUPS = "SELECT * FROM GROUPS";
    private static final String SAVE_GROUP = "INSERT INTO GROUPS (NAME, STREAMID) VALUES (?,?)";
    private static final String UPDATE_GROUP = "UPDATE GROUPS SET (NAME, STREAMID)  = (?, ?) WHERE ID = ?";
    private static final String DELETE_GROUP = "DELETE FROM GROUPS WHERE ID = ?";
    private static final String GET_GROUP_PERIOD_SCHEDULE = "SELECT * FROM GROUPS " +
            "INNER JOIN LECTUREGROUPS ON GROUPS.ID = LECTUREGROUPS.GROUPID " +
            "INNER JOIN LECTURES ON LECTURES.ID = LECTUREGROUPS.LECTUREID " +
            "WHERE GROUPID = ? AND DATE BETWEEN ? AND ?";

    private final JdbcTemplate jdbcTemplate;

    public GroupDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Group get(int id) {
        Group group = jdbcTemplate.queryForObject(GET_GROUP, new Object[]{id}, new BeanPropertyRowMapper<>(Group.class));
        logger.info("Объект {} взят из базы", group.getClass());
        return group;
    }

    @Override
    public List<Group> getAll() {
        List<Group> groups = jdbcTemplate.query(GET_ALL_GROUPS, new BeanPropertyRowMapper<>(Group.class));
        logger.info("Список обектов {} взят из базы", groups.getClass());
        return groups;

    }

    @Override
    public void save(Group group) {
        jdbcTemplate.update(SAVE_GROUP, group.getName(), group.getStreamId());
        logger.info("Объект {} сохранен в базу", group.getClass());
    }

    @Override
    public void update(Group group, Object[] params) {
        jdbcTemplate.update(UPDATE_GROUP, params[0], params[1], group.getId());
        logger.info("Объект {} обновлен", group.getClass());
    }

    @Override
    public void delete(Group group) {
        jdbcTemplate.update(DELETE_GROUP, group.getId());
        logger.info("Объект {} удален из базы", group.getClass());
    }

    public List<Lecture> getGroupPeriodLectures(int groupId, LocalDate startDate, LocalDate finishDate) {
        List<Lecture> lectures = jdbcTemplate.query(GET_GROUP_PERIOD_SCHEDULE, new BeanPropertyRowMapper<>(Lecture.class), groupId, startDate, finishDate);
        logger.info("Получено расписание для группы {} на даты {} - {}", get(groupId), startDate, finishDate);
        return lectures;
    }
}
