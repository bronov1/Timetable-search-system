package com.foxminded.university.dao;

import com.foxminded.university.entity.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentDao implements Dao<Department>{

    private static final String GET_ALL_DEPARTMENTS = "FROM Department";

    private final SessionFactory sessionFactory;

    public DepartmentDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Department get(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Department department = session.get(Department.class, id);
            transaction.commit();
            return department;
        }
    }

    @Override
    public List<Department> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            List<Department> departments = session.createQuery(GET_ALL_DEPARTMENTS, Department.class).list();
            transaction.commit();
            return departments;
        }
    }

    @Override
    public void save(Department department) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(department);
            transaction.commit();
        }
    }

    @Override
    public void update(Department department, Object[] params) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            department.setName((String) params[0]);
            session.saveOrUpdate(department);
            transaction.commit();
        }
    }

    @Override
    public void delete(Department department) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(department);
            transaction.commit();
        }
    }
}
