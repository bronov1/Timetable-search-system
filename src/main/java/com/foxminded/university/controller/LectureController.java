package com.foxminded.university.controller;

import com.foxminded.university.entity.Group;
import com.foxminded.university.entity.Lecture;
import com.foxminded.university.entity.LectureGroup;
import com.foxminded.university.entity.Professor;
import com.foxminded.university.service.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/lectures")
public class LectureController {

    private final LectureService lectureService;
    private final SubjectService subjectService;
    private final ProfessorService professorService;
    private final ClassroomService classroomService;
    private final GroupService groupService;
    private final LectureGroupService lectureGroupService;
    private List<Lecture> scheduleLectures = new ArrayList<>();
    private boolean scheduleStatus = false;

    public LectureController(LectureService lectureService, SubjectService subjectService, ProfessorService professorService, ClassroomService classroomService, GroupService groupService, LectureGroupService lectureGroupService) {
        this.lectureService = lectureService;
        this.subjectService = subjectService;
        this.professorService = professorService;
        this.classroomService = classroomService;
        this.groupService = groupService;
        this.lectureGroupService = lectureGroupService;
    }

    @GetMapping()
    public String showAll(Model model) {
        if (scheduleStatus) {
            model.addAttribute("lectures", scheduleLectures);
        }
        else {
            model.addAttribute("lectures", lectureService.getAllLectures());
        }
        model.addAttribute("subjectService", subjectService);
        model.addAttribute("professorService", professorService);
        model.addAttribute("classroomService", classroomService);
        model.addAttribute("groupService", groupService);
        scheduleStatus = false;
        return "lectures/index";
    }

    @GetMapping("/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("lecture", lectureService.getLecture(id));
        model.addAttribute("subjects", subjectService.getAllSubjects());
        model.addAttribute("professors", professorService.getAllProfessors());
        model.addAttribute("classrooms", classroomService.getAllClassrooms());
        model.addAttribute("groups", groupService.getAllGroups());
        return "lectures/edit";
    }

    @PostMapping("/{id}/update")
    public String updateLecture(@ModelAttribute("lectureGroup") LectureGroup lectureGroup, @ModelAttribute("lecture") Lecture lecture, @RequestParam("groups") int[] groups) {
        lectureGroupService.deleteGroupsFromLecture(lecture);
        lectureGroup.setLectureId(lecture.getId());
        for (int groupId : groups) {
            lectureGroup.setGroupId(groupId);
            lectureGroupService.save(lectureGroup);
        }
        lectureService.update(lecture);
        return "redirect:/lectures";
    }

    @GetMapping("/{id}/delete")
    public String delete(@ModelAttribute("lecture") Lecture lecture, @PathVariable("id") int id) {
        lecture.setId(id);
        lectureService.delete(lecture);
        return "redirect:/lectures";
    }

    @GetMapping("/new")
    public String showAddingForm(Model model, @ModelAttribute("lecture") Lecture lecture) {
        model.addAttribute("subjects", subjectService.getAllSubjects());
        model.addAttribute("professors", professorService.getAllProfessors());
        model.addAttribute("classrooms", classroomService.getAllClassrooms());
        model.addAttribute("groups", groupService.getAllGroups());
        return "lectures/new";
    }

    @PostMapping("/new")
    public String saveNewLecture(@ModelAttribute("lectureGroup") LectureGroup lectureGroup, @ModelAttribute("lecture") Lecture lecture, @RequestParam("groups") int[] groups) {
        lectureService.save(lecture);
        List<Lecture> lectures = lectureService.getAllLectures();
        Lecture lastLecture = lectures.get(lectures.size() - 1);
        lectureGroup.setLectureId(lastLecture.getId());
        for (int groupId : groups) {
            lectureGroup.setGroupId(groupId);
            lectureGroupService.save(lectureGroup);
        }
        return "redirect:/lectures";
    }

    @GetMapping("/showScheduleForm")
    public String showScheduleForm(Model model, @ModelAttribute("group") Group group,  @ModelAttribute("professor") Professor professor) {
        model.addAttribute("groups", groupService.getAllGroups());
        model.addAttribute("professors", professorService.getAllProfessors());
        return "lectures/schedule";
    }

    @PostMapping("/chooseGroupSchedule")
    public String chooseGroupSchedule(@ModelAttribute("group") Group group, @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate, @RequestParam("finishDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate finishDate) {
        scheduleLectures = groupService.getGroupSchedule(group.getId(), startDate, finishDate);
        scheduleStatus = true;
        return "redirect:/lectures";
    }

    @PostMapping("/chooseProfessorSchedule")
    public String chooseProfessorSchedule(@ModelAttribute("professor") Professor professor, @RequestParam("professorStartDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate, @RequestParam("professorFinishDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate finishDate) {
        scheduleLectures = professorService.getProfessorSchedule(professor.getId(), startDate, finishDate);
        scheduleStatus = true;
        return "redirect:/lectures";
    }
}
