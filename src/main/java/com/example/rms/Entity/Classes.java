package com.example.rms.Entity;

import javax.persistence.*;

@Entity
@Table(name ="classes")
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int class_id;
    private String class_name;
    private int course_id;
    private String slug;
    private String desciptions;

    public Classes(){
    }

    public Classes(int class_id, String class_name, int course_id, String slug, String desciptions) {
        this.class_id = class_id;
        this.class_name = class_name;
        this.course_id = course_id;
        this.slug = slug;
        this.desciptions = desciptions;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDesciptions() {
        return desciptions;
    }

    public void setDesciptions(String desciptions) {
        this.desciptions = desciptions;
    }
}
