package com.example.demo.Student.Model;

public class ClassRom {
    private int id;
    private String name;

    public ClassRom(String name) {
        this.name = name;
    }

    public ClassRom(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
