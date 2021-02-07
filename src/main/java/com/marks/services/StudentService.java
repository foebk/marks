package com.marks.services;

import com.marks.dtos.Student;

import java.util.List;
import java.util.UUID;

public interface StudentService {
    List<String> addStudent(Student student);

    List<String> editStudent(Student student);

    List<String> deleteStudent(UUID id);

    List<Student> getAllStudents();

    Student getStudentById(UUID id);
}
