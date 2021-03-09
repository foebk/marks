package com.marks.controllers;

import com.marks.dtos.IdModel;
import com.marks.dtos.Mark;
import com.marks.dtos.MarkRequest;
import com.marks.services.MarkService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/mark")
public class MarkController {
    private final MarkService markService;

    public MarkController(MarkService markService) {
        this.markService = markService;
    }

    @GetMapping("/getByStudentAndDiscipline")
    public List<Mark> getByStudentAndDiscipline(@RequestParam (name = "studentId") UUID studentId,
                                                  @RequestParam (name = "disciplineId") UUID disciplineId) {
        return markService.findByStudentAndDiscipline(studentId, disciplineId);
    }

    @GetMapping("/getByGroupAndDiscipline")
    public List<Mark> getByGroupAndDiscipline (@RequestParam (name = "groupId") UUID groupId,
                                                 @RequestParam (name = "disciplineId") UUID disciplineId) {
        return markService.findByGroupAndDiscipline(groupId, disciplineId);
    }

    @GetMapping("/getAll")
    public List<Mark> getAll() {
        return markService.findAll();
    }

    @PostMapping("/add")
    public List<String> addStudent (@RequestBody MarkRequest markRequest) {
        return markService.addMark(markRequest);
    }

    @PostMapping("/addAll")
    public List<String> addAllStudents(@RequestBody List<MarkRequest> markRequests) {
        return markService.addAllMarks(markRequests);
    }

    @PostMapping("/edit")
    public List<String> editStudent (@RequestBody MarkRequest markRequest) {
        return markService.editMark(markRequest);
    }

    @PostMapping("/delete")
    public List<String> deleteStudent(@RequestBody IdModel id) {
        return markService.deleteMark(id.getId());
    }
}
