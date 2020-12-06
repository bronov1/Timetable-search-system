package com.foxminded.university.controller;

import com.foxminded.university.entity.Group;
import com.foxminded.university.service.GroupService;
import com.foxminded.university.service.StreamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "groups/index";
    }

    @GetMapping("/new")
    public String showAddingForm(@ModelAttribute("group") Group group, Model model) {
        model.addAttribute("streams", streamService.getAllStreams());
        return "groups/new";
    }

    @PostMapping("/new")
    public String saveNewGroup(@ModelAttribute("group") Group group) {
        groupService.saveGroup(group);
        return "redirect:/groups";
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("group", groupService.getGroup(id));
        model.addAttribute("streams", streamService.getAllStreams());
        return "groups/edit";
    }

    @PostMapping("/{id}/update")
    public String updateGroup(@ModelAttribute("group") Group group) {
        groupService.updateGroup(group);
        return "redirect:/groups";
    }

    @GetMapping("/{id}/delete")
    public String delete(@ModelAttribute("lecture") Group group, @PathVariable("id") int id) {
        group.setId(id);
        groupService.deleteGroup(group);
        return "redirect:/groups";
    }
}
