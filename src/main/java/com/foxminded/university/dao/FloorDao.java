package com.foxminded.university.dao;

import com.foxminded.university.entity.Floor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FloorDao implements Dao<Floor>{

    private static final String GET_FLOOR = "SELECT * FROM FLOORS WHERE ID = ?";
    private static final String GET_ALL_FLOORS = "SELECT * FROM FLOORS";
    private static final String SAVE_FLOOR = "INSERT INTO FLOORS (NUMBER, BUILDINGID) VALUES (?, ?)";
    private static final String UPDATE_FLOOR = "UPDATE FLOORS SET (NUMBER, BUILDINGID)  = (?, ?) WHERE ID = ?";
    private static final String DELETE_FLOOR = "DELETE FROM FLOORS WHERE ID = ?";

    private final JdbcTemplate jdbcTemplate;

    public FloorDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

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
        jdbcTemplate.update(SAVE_FLOOR, floor.getNumber(), floor.getBuildingId());
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
