package com.foxminded.university.dao;

import com.foxminded.university.entity.Building;
import com.foxminded.university.entity.Group;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BuildingDao extends AbstractDao<Building> {

    private static final String GET_ALL_BUILDINGS = "FROM Building";

    public BuildingDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<Building> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            List<Building> buildings = session.createQuery(GET_ALL_BUILDINGS, Building.class).list();
            transaction.commit();
            return buildings;
        }
    }

    @Override
    public void update(Building building, Object[] params) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            building.setName((String) params[0]);
            building.setFloors((Integer) params[1]);
            session.saveOrUpdate(building);
            transaction.commit();
        }
    }

}
