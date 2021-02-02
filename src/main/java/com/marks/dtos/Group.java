package com.marks.dtos;

public class Group {
    private String id;
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Group(String id, String code) {
        this.id = id;
        this.code = code;
    }

    public Group() {
    }
}
