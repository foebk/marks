package com.marks.controllers;

import com.marks.dtos.IdModel;
import com.marks.dtos.Student;
import com.marks.dtos.StudentRequest;
import com.marks.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/student")
public class StudentsController {
    private final StudentService studentService;

    public StudentsController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public List<String> addStudent(@RequestBody StudentRequest student) {
        return studentService.addStudent(student);
    }

    @PostMapping("/edit")
    public List<String> editStudent(@RequestBody StudentRequest student) {
        return studentService.editStudent(student);
    }

    @PostMapping("/delete")
    public List<String> deleteStudent(@RequestBody IdModel id) {
        return studentService.deleteStudent(id.getId());
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
