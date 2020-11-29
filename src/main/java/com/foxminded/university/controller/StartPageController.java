package com.foxminded.university.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartPageController {

    @GetMapping()
    public String showStartPage() {
        return "index";
    }
}
