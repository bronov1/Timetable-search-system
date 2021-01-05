package com.foxminded.university.dao;

import com.foxminded.university.entity.Group;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public abstract class AbstractDao<T> {

    protected final SessionFactory sessionFactory;

    protected AbstractDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public abstract List<T> getAll();

    public abstract void update(T t, Object[] params);

    public T get(int id, Class<T> tClass){
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            T t = session.get(tClass, id);
            transaction.commit();
            return t;
        }
    }

    public void create(T t) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(t);
            transaction.commit();
        }
    }

    public void delete(T t) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(t);
            transaction.commit();
        }
    }
}
