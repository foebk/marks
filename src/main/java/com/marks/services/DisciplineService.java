package com.marks.services;

import com.marks.dtos.Discipline;

import java.util.List;
import java.util.UUID;

public interface DisciplineService {
    List<String> addDiscipline(Discipline discipline);

    List<String> editDiscipline(Discipline discipline);

    List<String> deleteDiscipline(UUID id);

    List<Discipline> findAllDisciplines();
}
