package com.marks.services;

import com.marks.dtos.Mark;
import com.marks.dtos.MarkRequest;

import java.util.List;
import java.util.UUID;

public interface MarkService {
    List<Mark> findByStudentAndDiscipline(UUID studentId, UUID disciplineId);

    List<Mark> findByGroupAndDiscipline(UUID groupId, UUID disciplineId);

    List<Mark> findAll();

    List<String> addMark(MarkRequest markRequest);

    List<String> addAllMarks(List<MarkRequest> markRequests);

    List<String> editMark(MarkRequest markRequest);

    List<String> deleteMark(UUID id);
}
