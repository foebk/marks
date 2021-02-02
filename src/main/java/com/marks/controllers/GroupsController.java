package com.marks.controllers;

import com.marks.controllers.services.GroupService;
import com.marks.dtos.Group;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GroupsController {
    private final GroupService groupService;

    public GroupsController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping("/addGroup")
    public List<String> addGroup(@RequestBody String code) {
        return groupService.addGroup(code);
    }

    @PostMapping("/editGroup")
    public List<String> editGroup(@RequestBody Group group) {

        return groupService.editGroup(group);
    }
}
