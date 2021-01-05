package com.foxminded.university.dao;

import com.foxminded.university.entity.Floor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class FloorDao extends AbstractDao<Floor>{

    public FloorDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}
