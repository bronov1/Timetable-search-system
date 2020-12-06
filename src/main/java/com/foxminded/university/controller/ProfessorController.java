package com.foxminded.university.controller;

import com.foxminded.university.entity.Group;
import com.foxminded.university.entity.Professor;
import com.foxminded.university.service.DepartmentService;
import com.foxminded.university.service.ProfessorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "professors/index";
    }

    @GetMapping("/new")
    public String showAddingForm(@ModelAttribute("professor") Professor professor, Model model) {
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "professors/new";
    }

    @PostMapping("/new")
    public String saveNewProfessor(@ModelAttribute("professor") Professor professor) {
        professorService.saveProfessor(professor);
        return "redirect:/professors";
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("professor", professorService.getProfessor(id));
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "professors/edit";
    }

    @PostMapping("/{id}/update")
    public String updateProfessor(@ModelAttribute("professor") Professor professor) {
        professorService.updateProfessor(professor);
        return "redirect:/professors";
    }

    @GetMapping("/{id}/delete")
    public String delete(@ModelAttribute("professor") Professor professor, @PathVariable("id") int id) {
        professor.setId(id);
        professorService.deleteProfessor(professor);
        return "redirect:/professors";
    }
}
