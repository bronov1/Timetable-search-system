package com.foxminded.university.controller;

import com.foxminded.university.service.DepartmentService;
import com.foxminded.university.service.ProfessorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/professors")
public class ProfessorController {

    private final ProfessorService professorService;
    private final DepartmentService departmentService;

    public ProfessorController(ProfessorService professorService, DepartmentService departmentService) {
        this.professorService = professorService;
        this.departmentService = departmentService;
    }


    @GetMapping()
    public String showAll(Model model) {
        model.addAttribute("professors", professorService.getAllProfessors());
        model.addAttribute("departmentService", departmentService);
        return "professors";
    }
}
