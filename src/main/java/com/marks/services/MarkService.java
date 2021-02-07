package com.marks.services;

import com.marks.dtos.Mark;

import java.util.List;
import java.util.UUID;

public interface MarkService {
    List<Mark> findByStudentAndDiscipline(UUID studentId, UUID disciplineId);

    List<Mark> findByGroupAndDiscipline(UUID groupId, UUID disciplineId);
}
