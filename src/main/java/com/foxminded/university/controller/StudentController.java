package com.foxminded.university.controller;

import com.foxminded.university.entity.Student;
import com.foxminded.university.service.GroupService;
import com.foxminded.university.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;
    private final GroupService groupService;

    public StudentController(StudentService studentService, GroupService groupService) {
        this.studentService = studentService;
        this.groupService = groupService;
    }

    @GetMapping()
    public String showAll(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("groupService", groupService);
        return "students/index";
    }

    @GetMapping("/new")
    public String showAddingForm(@ModelAttribute("student") Student student, Model model) {
        model.addAttribute("groups", groupService.getAllGroups());
        return "students/new";
    }

    @PostMapping("/new")
    public String saveNewStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("student", studentService.getStudent(id));
        model.addAttribute("groups", groupService.getAllGroups());
        return "students/edit";
    }

    @PostMapping("/{id}/update")
    public String updateStudent(@ModelAttribute("student") Student student) {
        studentService.updateStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/{id}/delete")
    public String delete(@ModelAttribute("student") Student student, @PathVariable("id") int id) {
        student.setId(id);
        studentService.deleteStudent(student);
        return "redirect:/students";
    }
}
