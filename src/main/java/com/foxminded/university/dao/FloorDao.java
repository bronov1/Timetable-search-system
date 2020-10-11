package com.foxminded.university.dao;

import com.foxminded.university.entity.Floor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FloorDao implements Dao<Floor>{

    private static final Logger logger = LoggerFactory.getLogger("FloorDao");

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
        Floor floor = jdbcTemplate.queryForObject(GET_FLOOR, new Object[]{id}, new BeanPropertyRowMapper<>(Floor.class));
        logger.info("Объект {} взят из базы", floor.getClass());
        return floor;
    }

    @Override
    public List<Floor> getAll() {
        List<Floor> floors = jdbcTemplate.query(GET_ALL_FLOORS, new BeanPropertyRowMapper<>(Floor.class));
        logger.info("Список обектов {} взят из базы", floors.getClass());
        return floors;
    }

    @Override
    public void save(Floor floor) {
        jdbcTemplate.update(SAVE_FLOOR, floor.getNumber(), floor.getBuildingId());
        logger.info("Объект {} сохранен в базу", floor.getClass());
    }

    @Override
    public void update(Floor floor, Object[] params) {
        jdbcTemplate.update(UPDATE_FLOOR, params[0], params[1], floor.getId());
        logger.info("Объект {} обновлен", floor.getClass());
    }

    @Override
    public void delete(Floor floor) {
            jdbcTemplate.update(DELETE_FLOOR, floor.getId());
        logger.info("Объект {} удален из базы", floor.getClass());
    }
}
