package com.marks.controllers;

import com.marks.dtos.Student;
import com.marks.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/student")
public class StudentsController {
    private final StudentService studentService;

    public StudentsController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public List<String> addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PostMapping("/edit")
    public List<String> editStudent(@RequestBody Student student) {
        return studentService.editStudent(student);
    }

    @PostMapping("/delete")
    public List<String> deleteStudent(@RequestBody UUID id) {
        return studentService.deleteStudent(id);
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/getById")
    public Student getStudentById(UUID id) {
        return studentService.getStudentById(id);
    }
}
