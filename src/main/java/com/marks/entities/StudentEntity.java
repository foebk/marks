package com.marks.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "students")
public class StudentEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    private String name;

    public StudentEntity() {
    }

    public StudentEntity(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public StudentEntity(String name, String surname, GroupEntity group, List<MarkEntity> marks) {
        this.name = name;
        this.surname = surname;
        this.group = group;
        this.marks = marks;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public GroupEntity getGroup() {
        return group;
    }

    public void setGroup(GroupEntity group) {
        this.group = group;
    }

    private String surname;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private GroupEntity group;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MarkEntity> marks;

    public List<MarkEntity> getMarks() {
        return marks;
    }

    public void setMarks(List<MarkEntity> marks) {
        this.marks = marks;
    }
}
