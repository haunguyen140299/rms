package com.example.rms.DTO;

import java.util.Date;

public class ProjectdoneDTO {
    Integer project_done_id;
    Date time_project;
    String name_project;
    Integer teamsize;
    String technical;
    String decription;
    Integer profile_id;

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

    public Integer getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(Integer profile_id) {
        this.profile_id = profile_id;
    }
}
