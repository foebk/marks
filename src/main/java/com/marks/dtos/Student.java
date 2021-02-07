package com.marks.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.UUID;

public class Student {
    private UUID id;
    private String name;
    private String surname;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Group group;

    public Student(UUID id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Student(UUID id, String name, String surname, Group group) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.group = group;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Student() {
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
