package com.foxminded.university.dao;

import com.foxminded.university.entity.Lecture;
import com.foxminded.university.entity.Professor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public class LectureDao implements Dao<Lecture> {

    private static final String GET_ALL_LECTURES = "FROM Lecture";
    private static final String GET_ALL_LECTURES_WITH_PROFESSOR = "FROM Lecture WHERE professorId = :id";

    private final SessionFactory sessionFactory;
    private final LectureGroupDao lectureGroupDao;

    public LectureDao(SessionFactory sessionFactory, LectureGroupDao lectureGroupDao) {
        this.sessionFactory = sessionFactory;
        this.lectureGroupDao = lectureGroupDao;
    }

    @Override
    public Lecture get(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Lecture lecture = session.get(Lecture.class, id);
            transaction.commit();
            return lecture;
        }
    }

    @Override
    public List<Lecture> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            List<Lecture> lectures = session.createQuery(GET_ALL_LECTURES, Lecture.class).list();
            transaction.commit();
            return lectures;
        }
    }

    @Override
    public void save(Lecture lecture) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(lecture);
            transaction.commit();
        }
    }

    @Override
    public void update(Lecture lecture, Object[] params) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            lecture.setSubjectId((Integer) params[0]);
            lecture.setProfessorId((Integer) params[1]);
            lecture.setDate((LocalDate) params[2]);
            lecture.setTime((LocalTime) params[3]);
            lecture.setClassroomId((Integer) params[4]);
            session.saveOrUpdate(lecture);
            transaction.commit();
        }
    }

    @Override
    public void delete(Lecture lecture) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            lectureGroupDao.deleteLectureForGroups(lecture);
            session.delete(lecture);
            transaction.commit();
        }
    }

    public void DeleteLecturesWithProfessor(Professor professor) {
        List<Lecture> lecturesWithProfessor = getAllLecturesWithProfessor(professor);
        for (Lecture lecture : lecturesWithProfessor) {
            delete(lecture);
        }
    }

    public List<Lecture> getAllLecturesWithProfessor(Professor professor) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Query<Lecture> query = session.createQuery(GET_ALL_LECTURES_WITH_PROFESSOR, Lecture.class);
            query.setParameter("id", professor.getId());
            List<Lecture> lecturesWithProfessor = query.list();
            transaction.commit();
            return lecturesWithProfessor;
        }
    }
}
