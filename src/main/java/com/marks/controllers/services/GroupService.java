package com.marks.controllers.services;

import com.marks.dtos.Group;

import java.util.List;
import java.util.UUID;

public interface GroupService {
    List<String> addGroup(Group group);

    List<String> editGroup(Group group);

    List<String> deleteGroup(UUID id);

    List<Group> findAllGroups();
}
