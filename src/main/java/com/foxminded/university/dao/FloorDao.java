package com.foxminded.university.dao;

import com.foxminded.university.entity.Floor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FloorDao implements Dao<Floor>{

    private static final String GET_ALL_floorS = "FROM Floor";

    private final SessionFactory sessionFactory;

    public FloorDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Floor get(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Floor floor = session.get(Floor.class, id);
            transaction.commit();
            return floor;
        }
    }

    @Override
    public List<Floor> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            List<Floor> floors = session.createQuery(GET_ALL_floorS, Floor.class).list();
            transaction.commit();
            return floors;
        }
    }

    @Override
    public void save(Floor floor) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(floor);
            transaction.commit();
        }
    }

    @Override
    public void update(Floor floor, Object[] params) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            floor.setNumber((Integer) params[0]);
            floor.setBuildingId((Integer) params[1]);
            session.saveOrUpdate(floor);
            transaction.commit();
        }
    }

    @Override
    public void delete(Floor floor) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(floor);
            transaction.commit();
        }
    }
}
