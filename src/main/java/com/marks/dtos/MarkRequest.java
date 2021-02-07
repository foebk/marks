package com.marks.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.UUID;

public class MarkRequest {
    private UUID id;
    @JsonProperty(value = "isVisited")
    private boolean isVisited;
    private Date date;
    private UUID disciplineId;
    private UUID studentId;

    public MarkRequest() {
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

    public UUID getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(UUID disciplineId) {
        this.disciplineId = disciplineId;
    }

    public UUID getStudentId() {
        return studentId;
    }

    public void setStudentId(UUID studentId) {
        this.studentId = studentId;
    }
}
