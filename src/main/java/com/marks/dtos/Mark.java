package com.marks.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.marks.entities.StudentEntity;

import java.util.Date;
import java.util.UUID;

public class Mark {
    private UUID id;
    @JsonProperty(value = "isVisited")
    private boolean isVisited;
    private Date date;
    private Discipline discipline;
    private StudentEntity student;

    public Mark() {
    }

    public Mark(UUID id, boolean isVisited, Date date, Discipline discipline, StudentEntity student) {
        this.id = id;
        this.isVisited = isVisited;
        this.date = date;
        this.discipline = discipline;
        this.student = student;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }
}
