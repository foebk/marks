package com.marks.controllers;

import com.marks.controllers.services.GroupService;
import com.marks.dtos.Group;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/group")
public class GroupsController {
    private final GroupService groupService;

    public GroupsController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping("/add")
    public List<String> addGroup(@RequestBody String code) {
        return groupService.addGroup(code);
    }

    @PostMapping("/edit")
    public List<String> editGroup(@RequestBody Group group) {
        return groupService.editGroup(group);
    }

    @GetMapping("/getAll")
    public List<Group> getAllGroups() {
        return groupService.findAllGroups();
    }

    @PostMapping("/delete")
    public List<String> deleteGroup(@RequestBody String uuid) {
        return groupService.deleteGroup(UUID.fromString(uuid));
    }
}
