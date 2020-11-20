package com.foxminded.university.controller;

import com.foxminded.university.entity.Group;
import com.foxminded.university.entity.Lecture;
import com.foxminded.university.service.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/lectures")
public class LectureController {

    private final LectureService lectureService;
    private final SubjectService subjectService;
    private final ProfessorService professorService;
    private final ClassroomService classroomService;
    private final GroupService groupService;

    public LectureController(LectureService lectureService, SubjectService subjectService, ProfessorService professorService, ClassroomService classroomService, GroupService groupService) {
        this.lectureService = lectureService;
        this.subjectService = subjectService;
        this.professorService = professorService;
        this.classroomService = classroomService;
        this.groupService = groupService;
    }

    @GetMapping()
    public String showAll(Model model) {
        if (!model.containsAttribute("lectures")) {
            model.addAttribute("lectures", lectureService.getAllLectures());
            model.addAttribute("subjectService", subjectService);
            model.addAttribute("professorService", professorService);
            model.addAttribute("classroomService", classroomService);
            model.addAttribute("groupService", groupService);
        }
        return "lectures/index";
    }

    @GetMapping("/forms")
    public String showForms(Model model, @ModelAttribute("lecture") Lecture lecture, @ModelAttribute("group") Group group) {
        model.addAttribute("lectures", lectureService.getAllLectures());
        model.addAttribute("subjects", subjectService.getAllSubjects());
        model.addAttribute("professors", professorService.getAllProfessors());
        model.addAttribute("classrooms", classroomService.getAllClassrooms());
        model.addAttribute("subjectService", subjectService);
        model.addAttribute("professorService", professorService);
        model.addAttribute("classroomService", classroomService);
        model.addAttribute("groupService", groupService);
        return "lectures/forms";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute("lecture") Lecture lecture) {
        lectureService.save(lecture);
        return "redirect:/lectures";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("lecture") Lecture lecture) {
        lectureService.delete(lecture);
        return "redirect:/lectures";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("lecture") Lecture lecture) {
        lectureService.update(lecture);
        return "redirect:/lectures";
    }

    @PostMapping("/index")
    public void getGroupSchedule(@ModelAttribute("group") Group group, @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate, @RequestParam("finishDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate finishDate, Model model) {
        List<Lecture> lectures = groupService.getGroupSchedule(group.getId(), startDate, finishDate);
        model.addAttribute("lectures", lectures);
        model.addAttribute("subjectService", subjectService);
        model.addAttribute("professorService", professorService);
        model.addAttribute("classroomService", classroomService);
        model.addAttribute("groupService", groupService);
        showAll(model);
    }
}
