package com.foxminded.university.service;

import com.foxminded.university.dao.LectureGroupDao;
import com.foxminded.university.entity.Lecture;
import com.foxminded.university.entity.LectureGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LectureGroupService {

    private static final Logger logger = LoggerFactory.getLogger("LectureGroupService");

    private final LectureGroupDao lectureGroupDaoDao;

    public LectureGroupService(LectureGroupDao lectureGroupDaoDao) {
        this.lectureGroupDaoDao = lectureGroupDaoDao;
    }

    public void save(LectureGroup lectureGroup) {
        lectureGroupDaoDao.save(lectureGroup);
        logger.info("Saved new lecture-group");
    }

    public void deleteGroupsFromLecture(Lecture lecture){
        lectureGroupDaoDao.deleteGroupsFromLecture(lecture);
        logger.info("Deleted groups for lecture with id {}", lecture.getId());
    }
}
