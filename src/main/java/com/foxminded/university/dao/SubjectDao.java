package com.foxminded.university.dao;


import com.foxminded.university.entity.Subject;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class SubjectDao extends AbstractDao<Subject> {

    public SubjectDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}

