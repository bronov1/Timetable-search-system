package com.foxminded.university.dao;

import com.foxminded.university.entity.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GroupDao implements Dao<Group>{

    private static final String GET_GROUP = "SELECT * FROM GROUPS WHERE ID = ?";
    private static final String GET_ALL_GROUPS = "SELECT * FROM GROUPS";
    private static final String SAVE_GROUP = "INSERT INTO GROUPS (NAME, STREAMID) VALUES (?,?)";
    private static final String UPDATE_GROUP = "UPDATE GROUPS SET (NAME, STREAMID)  = (?, ?) WHERE ID = ?";
    private static final String DELETE_GROUP = "DELETE FROM GROUPS WHERE ID = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

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
        jdbcTemplate.update(DELETE_GROUP, group.getId());
    }
}
