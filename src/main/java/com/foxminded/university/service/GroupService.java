package com.foxminded.university.service;

import com.foxminded.university.dao.*;
import com.foxminded.university.entity.Group;
import com.foxminded.university.entity.Lecture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    private static final Logger logger = LoggerFactory.getLogger("GroupService");

    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;
    private final LectureGroupRepository lectureGroupRepository;
    private final LectureRepository lectureRepository;

    public GroupService(GroupRepository groupRepository, StudentRepository studentRepository, LectureGroupRepository lectureGroupRepository, LectureRepository lectureRepository) {
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;
        this.lectureGroupRepository = lectureGroupRepository;
        this.lectureRepository = lectureRepository;
    }

    public List<Lecture> getGroupSchedule(int groupId, LocalDate startDate, LocalDate finishDate){
        List<Lecture> lectures = lectureRepository.findAllByGroupsAndLectureDateBetween(getGroup(groupId), startDate, finishDate);
        logger.info("Got schedule for group {} for dates {} - {}", groupRepository.findById(groupId), startDate, finishDate);
        return lectures;
    }

    public Iterable<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    public List<Group> getGroupsOnLecture(Lecture lecture) {
        List<Group> groups = groupRepository.findAllByLectures(lecture);
        logger.info("Got groups on lecture with id {} form Database", lecture.getId());
        return groups;
    }

    public void saveGroup(Group group) {
        groupRepository.save(group);
        logger.info("Saved new group");
    }

    public Group getGroup(int id) {
        Optional<Group> optionalGroup = groupRepository.findById(id);
        logger.info("Got group with id - {}", id);
        return optionalGroup.get();
    }

    public void updateGroup(Group group) {
        groupRepository.save(group);
        logger.info("Updated group with id - {}", group.getId());
    }

    public void deleteGroup(Group group) {
        studentRepository.deleteByGroup(group);
        lectureGroupRepository.deleteByGroup(group);
        groupRepository.delete(group);
        logger.info("Deleted group with id - {}", group.getId());
    }
}
