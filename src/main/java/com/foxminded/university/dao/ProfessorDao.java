package com.foxminded.university.dao;

import com.foxminded.university.entity.Lecture;
import com.foxminded.university.entity.Professor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class ProfessorDao implements Dao<Professor>{

    private static final String GET_ALL_PROFESSORS = "FROM Professor ";
    private static final String GET_PROFESSOR_PERIOD_SCHEDULE = "SELECT * FROM LECTURES " +
            "WHERE PROFESSORID = ? AND DATE BETWEEN ? AND ?";

    private final SessionFactory sessionFactory;
    private final LectureDao lectureDao;

    public ProfessorDao(SessionFactory sessionFactory, LectureDao lectureDao) {
        this.sessionFactory = sessionFactory;
        this.lectureDao = lectureDao;
    }

    @Override
    public Professor get(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Professor professor = session.get(Professor.class, id);
            transaction.commit();
            return professor;
        }
    }

    @Override
    public List<Professor> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            List<Professor> professors = session.createQuery(GET_ALL_PROFESSORS, Professor.class).list();
            transaction.commit();
            return professors;
        }
    }

    @Override
    public void save(Professor professors) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(professors);
            transaction.commit();
        }
    }

    @Override
    public void update(Professor professors, Object[] params) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            professors.setName((String) params[0]);
            professors.setDepartmentId((Integer) params[1]);
            session.saveOrUpdate(professors);
            transaction.commit();
        }
    }

    @Override
    public void delete(Professor professor) {
        try (Session session = sessionFactory.openSession()) {
            lectureDao.DeleteLecturesWithProfessor(professor);
            Transaction transaction = session.beginTransaction();
            session.delete(professor);
            transaction.commit();
        }
    }

    //TODO: Fix this method
    public List<Lecture> getProfessorPeriodLectures(int professorId, LocalDate startDate, LocalDate finishDate) {
        return null;
    }
}
