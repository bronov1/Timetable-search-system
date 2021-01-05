package com.foxminded.university.dao;

import com.foxminded.university.entity.Building;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class BuildingDao extends AbstractDao<Building> {

    public BuildingDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}
