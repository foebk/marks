package com.marks.controllers;

import com.marks.services.GroupService;
import com.marks.dtos.Group;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/group")
public class GroupsController {
    private final GroupService groupService;

    public GroupsController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping("/add")
    public List<String> addGroup(@RequestBody Group group) {
        return groupService.addGroup(group);
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
    public List<String> deleteGroup(@RequestBody UUID uuid) {
        return groupService.deleteGroup(uuid);
    }

    @GetMapping("/getById")
    public Group getGroupById(@RequestParam("id") String uuid) {
        return groupService.findGroupById(UUID.fromString(uuid));
    }
}
