package com.example.rms.Entity;

import javax.persistence.*;

@Entity
@Table(name = "learnresult")
public class Learnresult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer learn_result_id;
    private String name_learn;
    private String result_learn;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    public Learnresult() {

    }

    public Integer getLearn_result_id() {
        return learn_result_id;
    }

    public void setLearn_result_id(Integer learn_result_id) {
        this.learn_result_id = learn_result_id;
    }

    public String getName_learn() {
        return name_learn;
    }

    public void setName_learn(String name_learn) {
        this.name_learn = name_learn;
    }

    public String getResult_learn() {
        return result_learn;
    }

    public void setResult_learn(String result_learn) {
        this.result_learn = result_learn;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Learnresult(Integer learn_result_id, String name_learn, String result_learn, Profile profile) {
        this.learn_result_id = learn_result_id;
        this.name_learn = name_learn;
        this.result_learn = result_learn;
        this.profile = profile;
    }
}