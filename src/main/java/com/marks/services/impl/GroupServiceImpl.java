package com.marks.services.impl;

import com.marks.dtos.Group;
import com.marks.dtos.Student;
import com.marks.entities.GroupEntity;
import com.marks.repos.GroupRepository;
import com.marks.services.GroupService;
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
    public List<String> addGroup(Group group) {
        groupRepository.save(new GroupEntity(group.getCode()));

        return List.of();
    }

    @Override
    public List<String> editGroup(Group group) {
        var errors = new ArrayList<String>();
        var editable = groupRepository.findById(group.getId()).orElse(null);

        try {
            if (ObjectUtils.isEmpty(editable)) {
                errors.add("Группа не найдена.");
                logger.error(errors.get(0));
            }
            else {
                groupRepository.save(groupEditor(editable, group));
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        return errors;
    }

    @Override
    public List<String> deleteGroup(UUID id) {
        groupRepository.deleteById(id);
        return List.of();
    }

    @Override
    public List<Group> findAllGroups() {
        return groupRepository.findAll().stream().map(group -> {
            var students = group.getStudents().stream()
                    .map(entity -> new Student(
                            entity.getId(),
                            entity.getName(),
                            entity.getSurname()))
                    .collect(Collectors.toList());
            return new Group(group.getId(), group.getCode(), students);
        }).collect(Collectors.toList());
    }

    @Override
    public Group findGroupById(UUID id) {
        var groupEntity = groupRepository.findById(id).orElse(null);
        var students = groupEntity.getStudents().stream().map(entity -> new Student(
                entity.getId(),
                entity.getName(),
                entity.getSurname()))
        .collect(Collectors.toList());

        return new Group(groupEntity.getId(), groupEntity.getCode(), students);
    }

    private GroupEntity groupEditor(GroupEntity editable, Group group) {
        Optional.ofNullable(group.getCode()).ifPresent(editable::setCode);

        return editable;
    }
}
