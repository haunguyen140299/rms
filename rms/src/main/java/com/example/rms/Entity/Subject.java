package com.example.rms.Entity;

import javax.persistence.*;

@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_subject;
    private String name_subject;
    private String slug;
    private int id_teacher;
    private int id_mentor;
    private String desciptions;
    private int class_id;

    public Subject() {
    }

    public Subject(int id_subject, String name_subject, String slug, int id_teacher, int id_mentor, String desciptions, int class_id) {
        this.id_subject = id_subject;
        this.name_subject = name_subject;
        this.slug = slug;
        this.id_teacher = id_teacher;
        this.id_mentor = id_mentor;
        this.desciptions = desciptions;
        this.class_id = class_id;
    }

    public int getId_subject() {
        return id_subject;
    }

    public void setId_subject(int id_subject) {
        this.id_subject = id_subject;
    }

    public String getName_subject() {
        return name_subject;
    }

    public void setName_subject(String name_subject) {
        this.name_subject = name_subject;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public int getId_teacher() {
        return id_teacher;
    }

    public void setId_teacher(int id_teacher) {
        this.id_teacher = id_teacher;
    }

    public int getId_mentor() {
        return id_mentor;
    }

    public void setId_mentor(int id_mentor) {
        this.id_mentor = id_mentor;
    }

    public String getDesciptions() {
        return desciptions;
    }

    public void setDesciptions(String desciptions) {
        this.desciptions = desciptions;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }
}


