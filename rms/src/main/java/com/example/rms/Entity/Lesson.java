package com.example.rms.Entity;

import javax.persistence.*;

@Entity
@Table(name="lesson")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int id_subject;
    private String lesson_name;
    private int sesson;

    public Lesson() {
    }

    public Lesson(int id, int id_subject, String lesson_name, int sesson) {
        this.id = id;
        this.id_subject = id_subject;
        this.lesson_name = lesson_name;
        this.sesson = sesson;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_subject() {
        return id_subject;
    }

    public void setId_subject(int id_subject) {
        this.id_subject = id_subject;
    }

    public String getLesson_name() {
        return lesson_name;
    }

    public void setLesson_name(String lesson_name) {
        this.lesson_name = lesson_name;
    }

    public int getSesson() {
        return sesson;
    }

    public void setSesson(int sesson) {
        this.sesson = sesson;
    }
}
