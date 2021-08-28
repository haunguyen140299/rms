package com.example.rms.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "projectdone")
public class ProjectDone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer project_done_id;
    private Date time_project;
    private String name_project;
    private Integer teamsize;
    private String technical;
    private String decription;
    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    public ProjectDone() {

    }

    public Integer getProject_done_id() {
        return project_done_id;
    }

    public void setProject_done_id(Integer project_done_id) {
        this.project_done_id = project_done_id;
    }

    public Date getTime_project() {
        return time_project;
    }

    public void setTime_project(Date time_project) {
        this.time_project = time_project;
    }

    public String getName_project() {
        return name_project;
    }

    public void setName_project(String name_project) {
        this.name_project = name_project;
    }

    public Integer getTeamsize() {
        return teamsize;
    }

    public void setTeamsize(Integer teamsize) {
        this.teamsize = teamsize;
    }

    public String getTechnical() {
        return technical;
    }

    public void setTechnical(String technical) {
        this.technical = technical;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public ProjectDone(Integer project_done_id, Date time_project, String name_project, Integer teamsize, String technical, String decription, Profile profile) {
        this.project_done_id = project_done_id;
        this.time_project = time_project;
        this.name_project = name_project;
        this.teamsize = teamsize;
        this.technical = technical;
        this.decription = decription;
        this.profile = profile;
    }
}
