package com.foxminded.university.service;

import com.foxminded.university.dao.LectureGroupRepository;
import com.foxminded.university.entity.Lecture;
import com.foxminded.university.entity.LectureGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LectureGroupService {

    private static final Logger logger = LoggerFactory.getLogger("LectureGroupService");

    private final LectureGroupRepository lectureGroupRepository;

    public LectureGroupService(LectureGroupRepository lectureGroupRepository) {
        this.lectureGroupRepository = lectureGroupRepository;
    }

    public void save(LectureGroup lectureGroup) {
        lectureGroupRepository.save(lectureGroup.getLecture().getId(), lectureGroup.getGroup().getId());
        logger.info("Saved new lecture-group");
    }

    public void deleteGroupsFromLecture(Lecture lecture){
        lectureGroupRepository.deleteByLecture(lecture);
        logger.info("Deleted groups for lecture with id {}", lecture.getId());
    }
}
