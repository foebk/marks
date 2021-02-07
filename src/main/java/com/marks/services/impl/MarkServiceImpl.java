package com.marks.services.impl;

import com.marks.dtos.Mark;
import com.marks.entities.MarkEntity;
import com.marks.repos.MarkRepository;
import com.marks.services.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MarkServiceImpl implements MarkService {
    private final MarkRepository markRepository;

    @Autowired
    public MarkServiceImpl(MarkRepository markRepository) {
        this.markRepository = markRepository;
    }

    @Override
    public List<Mark> findByStudentAndDiscipline(UUID studentId, UUID disciplineId) {
        var entity = markRepository.findByStudentAndDiscipline(studentId, disciplineId);

        return null;
    }

    @Override
    public List<Mark> findByGroupAndDiscipline(UUID groupId, UUID disciplineId) {
        var entity = markRepository.findByGroupAndDiscipline(groupId, disciplineId);

        return null;
    }
}
