package com.marks.services.impl;

import com.marks.dtos.Group;
import com.marks.dtos.Student;
import com.marks.entities.StudentEntity;
import com.marks.repos.GroupRepository;
import com.marks.repos.StudentRepository;
import com.marks.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;

    public StudentServiceImpl(StudentRepository studentRepository, GroupRepository groupRepository) {
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
    }

    @Override
    public List<String> addStudent(Student student) {
        var group = groupRepository.findById(student.getGroup().getId()).orElse(null);

        var studentEntity = new StudentEntity(student.getName(), student.getSurname());
        studentEntity.setGroup(group);
        studentRepository.save(studentEntity);

        return null;
    }

    @Override
    public List<String> editStudent(Student student) {
        var editable = studentRepository.findById(student.getId()).orElse(null);
        studentRepository.save(studentEditor(editable, student));

        return null;
    }

    @Override
    public List<String> deleteStudent(UUID id) {
        studentRepository.deleteById(id);

        return null;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll().stream().map(entity -> {
            var group = new Group(entity.getGroup().getId(), entity.getGroup().getCode());

            return new Student(
                entity.getId(),
                entity.getName(),
                entity.getSurname(),
                group);
        }).collect(Collectors.toList());
    }

    @Override
    public Student getStudentById(UUID id) {
        var entity = studentRepository.findById(id).orElse(null);

        var groupEntity = entity.getGroup();
        var group = new Group(groupEntity.getId(), groupEntity.getCode());

        return new Student(entity.getId(), entity.getName(), entity.getSurname(), group);
    }


    private StudentEntity studentEditor(StudentEntity editable, Student student) {
        Optional.ofNullable(student.getName()).ifPresent(editable::setName);
        Optional.ofNullable(student.getSurname()).ifPresent(editable::setSurname);
        if (student.getGroup() != null) {
            editable.setGroup(groupRepository.findById(student.getGroup().getId()).orElse(null));
        }

        return editable;
    }
}
