package com.marks.services.impl;

import com.marks.dtos.Mark;
import com.marks.dtos.MarkRequest;
import com.marks.entities.MarkEntity;
import com.marks.repos.DisciplineRepository;
import com.marks.repos.MarkRepository;
import com.marks.repos.StudentRepository;
import com.marks.services.DisciplineService;
import com.marks.services.MarkService;
import com.marks.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MarkServiceImpl implements MarkService {
    private final MarkRepository markRepository;
    private final DisciplineRepository disciplineRepository;
    private final StudentRepository studentRepository;
    private final DisciplineService disciplineService;
    private final StudentService studentService;

    @Autowired
    public MarkServiceImpl(MarkRepository markRepository,
                           DisciplineRepository disciplineRepository,
                           StudentRepository studentRepository,
                           DisciplineService disciplineService,
                           StudentService studentService) {
        this.markRepository = markRepository;
        this.disciplineRepository = disciplineRepository;
        this.studentRepository = studentRepository;
        this.disciplineService = disciplineService;
        this.studentService = studentService;
    }

    @Override
    public List<Mark> findByStudentAndDiscipline(UUID studentId, UUID disciplineId) {
        return convertToDto(markRepository.findByStudentAndDiscipline(studentId, disciplineId));
    }

    @Override
    public List<Mark> findByGroupAndDiscipline(UUID groupId, UUID disciplineId) {
        return convertToDto(markRepository.findByGroupAndDiscipline(groupId, disciplineId));
    }

    @Override
    public List<Mark> findAll() {
        return convertToDto(markRepository.findAll());
    }

    @Override
    public List<String> addMark(MarkRequest markRequest) {
        markRepository.save(convertToEntity(markRequest));

        return null;
    }

    @Override
    public List<String> addAllMarks(List<MarkRequest> markRequests) {
        markRepository.saveAll(markRequests.stream().map(this::convertToEntity).collect(Collectors.toList()));

        return null;
    }


    @Override
    public List<String> editMark(MarkRequest markRequest) {
        markRepository.save(markEditor(markRepository.findById(markRequest.getId()).orElse(null),
                markRequest));

        return null;
    }

    @Override
    public List<String> deleteMark(UUID id) {
        markRepository.deleteById(id);

        return null;
    }

    private List<Mark> convertToDto(List<MarkEntity> entity) {
        return entity.stream().map(ent -> new Mark(ent.getId(),
                ent.isVisited(),
                ent.getDate(),
                ent.getMark(),
                disciplineService.findDisciplineById(ent.getDiscipline().getId()),
                studentService.getStudentById(ent.getStudent().getId())))
                .collect(Collectors.toList());
    }

    private MarkEntity convertToEntity(MarkRequest markRequest) {
        var markEntity = new MarkEntity();
        markEntity.setMark(markRequest.getMark());
        markEntity.setDate(markRequest.getDate());
        markEntity.setVisited(markRequest.isVisited());
        markEntity.setDiscipline(disciplineRepository.findById(markRequest.getDisciplineId()).orElse(null));
        markEntity.setStudent(studentRepository.findById(markRequest.getStudentId()).orElse(null));

        return markEntity;
    }

    private MarkEntity markEditor(MarkEntity editable, MarkRequest markRequest) {
        Optional.ofNullable(markRequest.getMark()).ifPresent(editable::setMark);
        Optional.ofNullable(markRequest.getDate()).ifPresent(editable::setDate);
        editable.setVisited(markRequest.isVisited());
        Optional.ofNullable(markRequest.getDisciplineId()).ifPresent(id -> {
            editable.setDiscipline(disciplineRepository.findById(id).orElse(null));
        });
        Optional.ofNullable(markRequest.getStudentId()).ifPresent(id -> {
            editable.setStudent(studentRepository.findById(id).orElse(null));
        });

        return editable;
    }
}
