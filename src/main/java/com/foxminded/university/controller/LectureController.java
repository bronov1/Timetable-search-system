package com.foxminded.university.controller;

import com.foxminded.university.service.ClassroomService;
import com.foxminded.university.service.LectureService;
import com.foxminded.university.service.ProfessorService;
import com.foxminded.university.service.SubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lectures")
public class LectureController {

    private final LectureService lectureService;
    private final SubjectService subjectService;
    private final ProfessorService professorService;
    private final ClassroomService classroomService;

    public LectureController(LectureService lectureService, SubjectService subjectService, ProfessorService professorService, ClassroomService classroomService) {
        this.lectureService = lectureService;
        this.subjectService = subjectService;
        this.professorService = professorService;
        this.classroomService = classroomService;
    }

    @GetMapping()
    public String showAll(Model model) {
        model.addAttribute("lectures", lectureService.getAllLectures());
        model.addAttribute("subjectService", subjectService);
        model.addAttribute("professorService", professorService);
        model.addAttribute("classroomService", classroomService);
        return "tables/lectures";
    }
}
