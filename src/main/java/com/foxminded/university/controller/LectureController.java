package com.foxminded.university.controller;

import com.foxminded.university.entity.Group;
import com.foxminded.university.entity.Lecture;
import com.foxminded.university.entity.LectureGroup;
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
    private List<Lecture> lecturesForGroup = new ArrayList<>();
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
            model.addAttribute("lectures", lecturesForGroup);
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
        return "lectures/edit";
    }

    @PostMapping("/{id}/update")
    public String update(@ModelAttribute("lecture") Lecture lecture) {
        lectureService.update(lecture);
        return "redirect:/lectures";
    }

    @PostMapping("/{id}/delete")
    public String delete(@ModelAttribute("lecture") Lecture lecture) {
        lectureService.delete(lecture);
        return "redirect:/lectures";
    }

    @GetMapping("/new")
    public String showForms(Model model, @ModelAttribute("lecture") Lecture lecture) {
        model.addAttribute("subjects", subjectService.getAllSubjects());
        model.addAttribute("professors", professorService.getAllProfessors());
        model.addAttribute("classrooms", classroomService.getAllClassrooms());
        return "lectures/new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("lecture") Lecture lecture) {
        lectureService.save(lecture);
        return "redirect:/lectures";
    }

    @GetMapping("/{id}/addGroups")
    public String selectGroups(Model model, @PathVariable("id") int lectureId, @ModelAttribute("lectureGroup") LectureGroup lectureGroup) {
        model.addAttribute("lectureId", lectureId);
        model.addAttribute("groups", groupService.getAllGroups());
        return "lectures/lecture_groups";
    }

    @PostMapping("/{id}/addGroups")
    public String addGroups(@ModelAttribute("lectureGroup") LectureGroup lectureGroup, @PathVariable("id") int lectureId) {
        lectureGroup.setLectureId(lectureId);
        lectureGroupService.save(lectureGroup);
        return "redirect:/lectures";
    }

    @GetMapping("/showScheduleForm")
    public String showScheduleForm(Model model, @ModelAttribute("group") Group group) {
        model.addAttribute("groups", groupService.getAllGroups());
        return "lectures/schedule";
    }

    @PostMapping("/chooseSchedule")
    public String chooseSchedule(@ModelAttribute("group") Group group, @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate, @RequestParam("finishDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate finishDate) {
        lecturesForGroup = groupService.getGroupSchedule(group.getId(), startDate, finishDate);
        scheduleStatus = true;
        return "redirect:/lectures";
    }
    
    /**
     * Methods for adding groups with checkbox
     *
     *
     *
    @GetMapping("/{id}/addGroups")
    public String selectGroups(Model model, @PathVariable("id") int lectureId) {
        model.addAttribute("groupContainer", new ArrayList<Integer>());
        model.addAttribute("lectureId", lectureId);
        model.addAttribute("groups", groupService.getAllGroups());
        return "lectures/lecture_groups";
    }

    @PostMapping("/{id}/addGroups")
    public String addGroups(@PathVariable("id") int lectureId, @RequestParam("groupContainer") ArrayList<Integer> selectedGroups) {
        for (Integer groupId : selectedGroups){
            lectureGroupService.save(new LectureGroup(lectureId, groupId));
        }
        return "redirect:/lectures";
    }
     */
}
