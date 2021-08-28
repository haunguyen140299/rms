package com.example.rms.Entity;

import javax.persistence.*;

@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_teacher;
    private String name_teacher;

    public Teacher(int id_teacher, String name_teacher) {
        this.id_teacher = id_teacher;
        this.name_teacher = name_teacher;
    }
    public Teacher(){

    }
    public int getId_teacher() {
        return id_teacher;
    }

    public void setId_teacher(int id_teacher) {
        this.id_teacher = id_teacher;
    }

    public String getName_teacher() {
        return name_teacher;
    }

    public void setName_teacher(String name_teacher) {
        this.name_teacher = name_teacher;
    }
}
