package com.foxminded.university.controllers;

import com.foxminded.university.dao.LectureDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lectures")
public class LectureController {

    private final LectureDao lectureDao;

    @Autowired
    public LectureController(LectureDao lectureDao) {
        this.lectureDao = lectureDao;
    }

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("lectures", lectureDao.getAll());
        return "lectures/lectures";
    }
}
