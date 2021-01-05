package com.foxminded.university.dao;

import com.foxminded.university.entity.Building;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class BuildingDao extends AbstractDao<Building> {

    public BuildingDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public void update(Building building) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            building.setName(building.getName());
            building.setFloors(building.getFloors());
            session.saveOrUpdate(building);
            transaction.commit();
        }
    }

}
