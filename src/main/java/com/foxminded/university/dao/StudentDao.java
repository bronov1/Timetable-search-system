package com.foxminded.university.dao;

import com.foxminded.university.entity.Group;
import com.foxminded.university.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
public class StudentDao implements Dao<Student> {

    private static final String GET_STUDENT = "SELECT * FROM STUDENTS WHERE ID = ?";
    private static final String GET_ALL_STUDENTS = "SELECT * FROM STUDENTS";
    private static final String SAVE_STUDENT = "INSERT INTO STUDENTS (NAME, GROUPID) VALUES (?,?)";
    private static final String UPDATE_STUDENT = "UPDATE STUDENTS SET (NAME, GROUPID)  = (?, ?) WHERE ID = ?";
    private static final String DELETE_STUDENT = "DELETE FROM STUDENTS WHERE ID = ?";
    private static final String DELETE_STUDENTS_FROM_GROUP = "DELETE FROM STUDENTS WHERE GROUPID = ?";

    private final JdbcTemplate jdbcTemplate;
    private final SessionFactory sessionFactory;

    public StudentDao(JdbcTemplate jdbcTemplate, SessionFactory sessionFactory) {
        this.jdbcTemplate = jdbcTemplate;
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Student get(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Student student = session.get(Student.class, id);
            transaction.commit();
            return student;
        }
    }

    @Override
    public List<Student> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            List<Student> students = session.createQuery("from Student", Student.class).list();
            transaction.commit();
            return students;
        }
    }

    @Override
    public void save(Student student) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        }
    }

    @Override
    public void update(Student student, Object[] params) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            student.setName((String) params[0]);
            student.setGroupId((Integer) params[1]);
            session.saveOrUpdate(student);
            transaction.commit();
        }
    }

    @Override
    public void delete(Student student) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(student);
            transaction.commit();
        }
    }

    public void DeleteStudentsFromGroup(Group group) {
        jdbcTemplate.update(DELETE_STUDENTS_FROM_GROUP, group.getId());
    }
}
