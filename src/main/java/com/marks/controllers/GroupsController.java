package com.marks.controllers;

import com.marks.entities.StudentEntity;
import com.marks.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarksController {
    private final StudentRepository studentRepository;

    @Autowired
    public MarksController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping("/addGroup")
    public String addGroup(@RequestParam("number") String code) {

    }
}
