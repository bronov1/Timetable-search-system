package com.foxminded.university.dao;

import com.foxminded.university.entity.Classroom;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ClassroomDao extends AbstractDao<Classroom>{

    public ClassroomDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}
