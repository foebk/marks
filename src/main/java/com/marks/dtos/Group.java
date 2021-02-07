package com.marks.dtos;

import java.util.List;
import java.util.UUID;

public class Group {
    private UUID id;
    private String code;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    private List<Student> students;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Group(UUID id, String code) {
        this.id = id;
        this.code = code;
    }

    public Group(UUID id, String code, List<Student> students) {
        this.id = id;
        this.code = code;
        this.students = students;
    }

    public Group() {
    }
}
