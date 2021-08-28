package com.example.rms.DTO;

public class LearnresultDTO {
    Integer learn_result_id;
    String name_learn;
    String result_learn;
    Integer profile_id;

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

    public Integer getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(Integer profile_id) {
        this.profile_id = profile_id;
    }
}
