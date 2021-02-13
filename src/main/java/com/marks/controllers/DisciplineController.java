package com.marks.controllers;

import com.marks.dtos.Discipline;
import com.marks.services.DisciplineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/discipline")
public class DisciplineController {
    private final DisciplineService disciplineService;

    public DisciplineController(DisciplineService disciplineService) {
        this.disciplineService = disciplineService;
    }

    @PostMapping("/add")
    public List<String> addDiscipline(@RequestBody Discipline discipline) {
        return disciplineService.addDiscipline(discipline);
    }

    @PostMapping("/edit")
    public List<String> editDiscipline(@RequestBody Discipline discipline) {
        return disciplineService.editDiscipline(discipline);
    }

    @PostMapping("/delete")
    public List<String> deleteDiscipline(@RequestBody UUID id) {
        return disciplineService.deleteDiscipline(id);
    }

    @GetMapping("/getAll")
    public List<Discipline> getAllDisciplines() {
        return disciplineService.findAllDisciplines();
    }
}
