package com.marks.services.impl;

import com.marks.dtos.Discipline;
import com.marks.entities.DisciplineEntity;
import com.marks.repos.DisciplineRepository;
import com.marks.services.DisciplineService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DisciplineServiceImpl implements DisciplineService {
    private final DisciplineRepository disciplineRepository;

    public DisciplineServiceImpl(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }

    @Override
    public List<String> addDiscipline(Discipline discipline) {
        disciplineRepository.save(new DisciplineEntity(discipline.getName()));

        return null;

    }

    @Override
    public List<String> editDiscipline(Discipline discipline) {
        disciplineRepository.save(
                disciplineEditor(disciplineRepository.findById(discipline.getId()).orElse(null), discipline));

        return null;
    }

    @Override
    public List<String> deleteDiscipline(UUID id) {
        disciplineRepository.deleteById(id);

        return null;
    }

    @Override
    public List<Discipline> findAllDisciplines() {
        return disciplineRepository.findAll().stream()
                .map(entity -> new Discipline(entity.getId(), entity.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public Discipline findDisciplineById(UUID id) {
        var disciplineEntity = disciplineRepository.findById(id).orElse(null);
        return new Discipline(disciplineEntity.getId(), disciplineEntity.getName());
    }


    private DisciplineEntity disciplineEditor(DisciplineEntity editable, Discipline discipline) {
        if (editable != null) {
            Optional.of(discipline.getName()).ifPresent(editable::setName);
        }

        return editable;
    }
}
