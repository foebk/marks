package com.marks.services;

import com.marks.dtos.Student;
import com.marks.dtos.StudentRequest;

import java.util.List;
import java.util.UUID;

public interface StudentService {
    List<String> addStudent(StudentRequest student);

    List<String> editStudent(StudentRequest student);

    List<String> deleteStudent(UUID id);

    List<Student> getAllStudents();

    Student getStudentById(UUID id);
}
