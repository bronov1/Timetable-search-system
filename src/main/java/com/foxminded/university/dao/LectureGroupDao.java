package com.foxminded.university.dao;

import com.foxminded.university.entity.Group;
import com.foxminded.university.entity.Lecture;
import com.foxminded.university.entity.LectureGroup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class LectureGroupDao implements Dao<LectureGroup> {

    private static final String GET_ALL_LECTURE_GROUP = "FROM LectureGroup ";
    private static final String DELETE_LECTURE_FOR_GROUPS = "DELETE FROM LectureGroup WHERE lectureId = :lectureId";
    private static final String DELETE_GROUP_FROM_LECTURE = "DELETE FROM LectureGroup WHERE groupId = :groupId";

    private final SessionFactory sessionFactory;

    public LectureGroupDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public LectureGroup get(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            LectureGroup lectureGroup = session.get(LectureGroup.class, id);
            transaction.commit();
            return lectureGroup;
        }
    }

    @Override
    public List<LectureGroup> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            List<LectureGroup> lectureGroups = session.createQuery(GET_ALL_LECTURE_GROUP, LectureGroup.class).list();
            transaction.commit();
            return lectureGroups;
        }
    }

    @Override
    public void save(LectureGroup lectureGroup) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(lectureGroup);
            transaction.commit();
        }
    }

    @Override
    public void update(LectureGroup lectureGroup, Object[] params) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            lectureGroup.setLectureId((Integer) params[0]);
            lectureGroup.setGroupId((Integer) params[1]);
            session.saveOrUpdate(lectureGroup);
            transaction.commit();
        }
    }

    @Override
    public void delete(LectureGroup lectureGroup) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(lectureGroup);
            transaction.commit();
        }
    }

    public void deleteLectureForGroups(Lecture lecture) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery(DELETE_LECTURE_FOR_GROUPS);
            query.setParameter("lectureId", lecture.getId());
            query.executeUpdate();
            transaction.commit();
        }
    }

    public void DeleteGroupFromLecture(Group group) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery(DELETE_GROUP_FROM_LECTURE);
            query.setParameter("groupId", group.getId());
            query.executeUpdate();
            transaction.commit();
        }
    }
}
