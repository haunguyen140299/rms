package com.example.rms.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer profile_id;
    private String name;
    private Date birthday;
    private String hobby;
    private String phone;
    private String email;
    private String address;
    private String group_obj;
    private String image;
    private String prCandidate;
    private  Date createDate;
    private Integer idAccount;
    @OneToMany(mappedBy = "profile", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonBackReference("studyprocess")
    private Set<StudyProcess> studyProcesses;
    @OneToMany(mappedBy = "profile", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonBackReference("projectdone")
    private Set<ProjectDone> projectDones;
    @OneToMany(mappedBy = "profile", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonBackReference("achivement")
    private Set<Achievements> achievements;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonBackReference("learnresult")
    private Set<Learnresult> learnresults;

    public Profile() {

    }

    public Profile(Integer profile_id, String name, Date birthday, String hobby, String phone, String email, String address, String group_obj, String image, String prCandidate, Date createDate, Integer idAccount, Set<StudyProcess> studyProcesses, Set<ProjectDone> projectDones, Set<Achievements> achievements, Set<Learnresult> learnresults) {
        this.profile_id = profile_id;
        this.name = name;
        this.birthday = birthday;
        this.hobby = hobby;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.group_obj = group_obj;
        this.image = image;
        this.prCandidate = prCandidate;
        this.createDate = createDate;
        this.idAccount = idAccount;
        this.studyProcesses = studyProcesses;
        this.projectDones = projectDones;
        this.achievements = achievements;
        this.learnresults = learnresults;
    }

    public Integer getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(Integer profile_id) {
        this.profile_id = profile_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGroup_obj() {
        return group_obj;
    }

    public void setGroup_obj(String group_obj) {
        this.group_obj = group_obj;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrCandidate() {
        return prCandidate;
    }

    public void setPrCandidate(String prCandidate) {
        this.prCandidate = prCandidate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }

    public Set<StudyProcess> getStudyProcesses() {
        return studyProcesses;
    }

    public void setStudyProcesses(Set<StudyProcess> studyProcesses) {
        this.studyProcesses = studyProcesses;
    }

    public Set<ProjectDone> getProjectDones() {
        return projectDones;
    }

    public void setProjectDones(Set<ProjectDone> projectDones) {
        this.projectDones = projectDones;
    }

    public Set<Achievements> getAchievements() {
        return achievements;
    }

    public void setAchievements(Set<Achievements> achievements) {
        this.achievements = achievements;
    }

    public Set<Learnresult> getLearnresults() {
        return learnresults;
    }

    public void setLearnresults(Set<Learnresult> learnresults) {
        this.learnresults = learnresults;
    }
}
