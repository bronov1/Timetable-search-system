package com.foxminded.university.dao;

import com.foxminded.university.entity.Group;
import com.foxminded.university.entity.Lecture;
import com.foxminded.university.entity.Professor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class ProfessorDao extends AbstractDao<Professor> {

    private static final String GET_ALL_PROFESSORS = "FROM Professor ";
    private static final String GET_PROFESSOR_PERIOD_SCHEDULE = "SELECT l FROM Lecture l " +
            "WHERE l.professorId = :professorId AND l.date BETWEEN :startDate AND :finishDate";

    private final LectureDao lectureDao;

    public ProfessorDao(SessionFactory sessionFactory, LectureDao lectureDao) {
        super(sessionFactory);
        this.lectureDao = lectureDao;
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
    public void update(Professor professor) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            professor.setName(professor.getName());
            professor.setDepartmentId(professor.getDepartmentId());
            session.saveOrUpdate(professor);
            transaction.commit();
        }
    }

    @Override
    public void delete(Professor professor) {
        lectureDao.DeleteLecturesWithProfessor(professor);
        super.delete(professor);
    }

    public List<Lecture> getProfessorPeriodLectures(int professorId, LocalDate startDate, LocalDate finishDate) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Query<Lecture> query = session.createQuery(GET_PROFESSOR_PERIOD_SCHEDULE, Lecture.class);
            query.setParameter("professorId", professorId);
            query.setParameter("startDate", startDate);
            query.setParameter("finishDate", finishDate);
            List<Lecture> professorPeriodLectures = query.list();
            transaction.commit();
            return professorPeriodLectures;
        }
    }

}
