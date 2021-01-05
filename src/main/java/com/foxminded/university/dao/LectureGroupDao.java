package com.foxminded.university.dao;

import com.foxminded.university.entity.Group;
import com.foxminded.university.entity.Lecture;
import com.foxminded.university.entity.LectureGroup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository
public class LectureGroupDao extends AbstractDao<LectureGroup> {

    private static final String DELETE_LECTURE_FOR_GROUPS = "DELETE FROM LectureGroup WHERE lectureId = :lectureId";
    private static final String DELETE_GROUP_FROM_LECTURE = "DELETE FROM LectureGroup WHERE groupId = :groupId";

    public LectureGroupDao(SessionFactory sessionFactory) {
        super(sessionFactory);
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

    public void deleteGroupFromLecture(Group group) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery(DELETE_GROUP_FROM_LECTURE);
            query.setParameter("groupId", group.getId());
            query.executeUpdate();
            transaction.commit();
        }
    }
}
