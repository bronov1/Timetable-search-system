package com.foxminded.university.controller;

import com.foxminded.university.service.GroupService;
import com.foxminded.university.service.StreamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/groups")
public class GroupController {

    private final GroupService groupService;
    private final StreamService streamService;

    public GroupController(GroupService groupService, StreamService streamService) {
        this.groupService = groupService;
        this.streamService = streamService;
    }

    @GetMapping()
    public String showAll(Model model) {
        model.addAttribute("groups", groupService.getAllGroups());
        model.addAttribute("streamService", streamService);
        return "groups";
    }
}
