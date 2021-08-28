package com.example.rms.Entity;

import javax.persistence.*;

@Entity
@Table(name = "mentor")
public class Mentor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_mentor;
    private String name_mentor;

    public Mentor(int id_mentor, String name_mentor) {
        this.id_mentor = id_mentor;
        this.name_mentor = name_mentor;
    }
    public Mentor(){

    }

    public int getId_mentor() {
        return id_mentor;
    }

    public void setId_mentor(int id_mentor) {
        this.id_mentor = id_mentor;
    }

    public String getName_mentor() {
        return name_mentor;
    }

    public void setName_mentor(String name_mentor) {
        this.name_mentor = name_mentor;
    }
}
