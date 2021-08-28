package com.example.rms.Entity;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="studyprocess")
public class StudyProcess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer study_process_id;
    private String school;
    private Date time_process;
    private String note;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    public StudyProcess() {

    }

    public Integer getStudy_process_id() {
        return study_process_id;
    }

    public void setStudy_process_id(Integer study_process_id) {
        this.study_process_id = study_process_id;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Date getTime_process() {
        return time_process;
    }

    public void setTime_process(Date time_process) {
        this.time_process = time_process;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public StudyProcess(Integer study_process_id, String school, Date time_process, String note, Profile profile) {
        this.study_process_id = study_process_id;
        this.school = school;
        this.time_process = time_process;
        this.note = note;
        this.profile = profile;
    }
}
