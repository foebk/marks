package com.marks.controllers.services.impl;

import com.marks.controllers.services.GroupService;
import com.marks.dtos.Group;
import com.marks.entities.GroupEntity;
import com.marks.repos.GroupRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final Logger logger;

    @Autowired
    public GroupServiceImpl(GroupRepository groupRepository, Logger logger) {
        this.groupRepository = groupRepository;
        this.logger = logger;
    }

    @Override
    public List<String> addGroup(String code) {
        groupRepository.save(new GroupEntity(code));

        return List.of();
    }

    @Override
    public List<String> editGroup(Group group) {
        var errors = new ArrayList<String>();
        var editable = groupRepository.findById(UUID.fromString(group.getId())).orElse(null);

        try {
            if (ObjectUtils.isEmpty(editable)) {
                errors.add("Группа не найдена.");
                logger.error(errors.get(0));
            }
            else {
                groupRepository.save(groupEdittor(editable, group));
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        return errors;
    }

    @Override
    public List<String> deleteGroup(UUID id) {
        return null;
    }

    @Override
    public List<Group> findAllGroups() {
        return groupRepository.findAll().stream().map(group -> new Group(group.getId().toString(), group.getCode()))
                .collect(Collectors.toList());
    }

    private GroupEntity groupEdittor(GroupEntity editable, Group group) {
        Optional.ofNullable(group.getCode()).ifPresent(editable::setCode);

        return editable;
    }
}
