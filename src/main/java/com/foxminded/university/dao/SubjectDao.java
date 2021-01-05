package com.foxminded.university.dao;


import com.foxminded.university.entity.Subject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubjectDao extends AbstractDao<Subject> {

    private static final String GET_ALL_SUBJECTS = "FROM Subject";

    public SubjectDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public void update(Subject subject) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            subject.setName(subject.getName());
            session.saveOrUpdate(subject);
            transaction.commit();
        }
    }
}

