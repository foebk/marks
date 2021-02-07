package com.marks.controllers;

import com.marks.dtos.Mark;
import com.marks.services.MarkService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/mark")
public class MarkController {
    private final MarkService markService;

    public MarkController(MarkService markService) {
        this.markService = markService;
    }

    @GetMapping("/findByStudentAndDiscipline")
    private List<Mark> findByStudentAndDiscipline(@RequestParam (name = "studentId") UUID studentId,
                                                  @RequestParam (name = "disciplineId") UUID disciplineId) {
        return markService.findByStudentAndDiscipline(studentId, disciplineId);
    }

    @GetMapping("/findByGroupAndDiscipline")
    private List<Mark> findByGroupAndDiscipline (@RequestParam (name = "groupId") UUID groupId,
                                                 @RequestParam (name = "disciplineId") UUID disciplineId) {
        return markService.findByGroupAndDiscipline(groupId, disciplineId);
    }
}
