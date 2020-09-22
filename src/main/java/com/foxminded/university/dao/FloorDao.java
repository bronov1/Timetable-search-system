package com.foxminded.university.dao;

import com.foxminded.university.entity.Floor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class FloorDao implements Dao<Floor>{

    private static final String GET_FLOOR = "Select * from floors where id = ?";
    private static final String GET_ALL_FLOORS = "Select * from floors";
    private static final String SAVE_FLOOR = "Insert into floors (number, building) values (?, ?)";
    private static final String UPDATE_FLOOR = "Update floors set (number, building)  = (?, ?) where id = ?";
    private static final String DELETE_FLOOR = "Delete from floors where id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Floor get(int id) {
        return jdbcTemplate.queryForObject(GET_FLOOR, new Object[]{id}, new BeanPropertyRowMapper<>(Floor.class));
    }

    @Override
    public List<Floor> getAll() {
        return jdbcTemplate.query(GET_ALL_FLOORS, new BeanPropertyRowMapper<>(Floor.class));
    }

    @Override
    public void save(Floor floor) {
        jdbcTemplate.update(SAVE_FLOOR, floor.getNumber(), floor.getBuilding());
    }

    @Override
    public void update(Floor floor, Object[] params) {
        jdbcTemplate.update(UPDATE_FLOOR, params[0], params[1], floor.getId());
    }

    @Override
    public void delete(Floor floor) {
            jdbcTemplate.update(DELETE_FLOOR, floor.getId());
    }
}
