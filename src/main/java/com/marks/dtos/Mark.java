package com.marks.dtos;

import java.util.Date;
import java.util.UUID;

public class Mark {
    private UUID id;
    private boolean isVisited;
    private Date date;
    private Integer mark;
    private Discipline discipline;
    private Student studentId;

    public Mark(UUID id, boolean isVisited, Date date, Integer mark, Discipline discipline, Student studentId) {
        this.id = id;
        this.isVisited = isVisited;
        this.date = date;
        this.mark = mark;
        this.discipline = discipline;
        this.studentId = studentId;
    }

    public Mark() {
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

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }
}
