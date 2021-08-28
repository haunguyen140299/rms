package com.example.rms.DTO;

import java.util.Date;

public class StudyprocessDTO {
    Integer study_process_id;
    String note;
    String school;
    Date time_process;
    Integer profile_id;

    public Integer getStudy_process_id() {
        return study_process_id;
    }

    public void setStudy_process_id(Integer study_process_id) {
        this.study_process_id = study_process_id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    public Integer getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(Integer profile_id) {
        this.profile_id = profile_id;
    }
}
