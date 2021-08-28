package com.example.rms.DTO;

import java.util.Date;

public class EvaluationDTO {
    private int evaluation_id;
    private String evaluation_name;
    private int creater_id;
    private Date day_create;
    private int template_evaluate_id;
    private int person_review_id;

    public EvaluationDTO() {
    }

    public EvaluationDTO(int evaluation_id, String evaluation_name, int creater_id, Date day_create, int template_evaluate_id, int person_review_id) {
        this.evaluation_id = evaluation_id;
        this.evaluation_name = evaluation_name;
        this.creater_id = creater_id;
        this.day_create = day_create;
        this.template_evaluate_id = template_evaluate_id;
        this.person_review_id = person_review_id;
    }

    public int getEvaluation_id() {
        return evaluation_id;
    }

    public void setEvaluation_id(int evaluation_id) {
        this.evaluation_id = evaluation_id;
    }

    public String getEvaluation_name() {
        return evaluation_name;
    }

    public void setEvaluation_name(String evaluation_name) {
        this.evaluation_name = evaluation_name;
    }

    public int getCreater_id() {
        return creater_id;
    }

    public void setCreater_id(int creater_id) {
        this.creater_id = creater_id;
    }

    public Date getDay_create() {
        return day_create;
    }

    public void setDay_create(Date day_create) {
        this.day_create = day_create;
    }

    public int getTemplate_evaluate_id() {
        return template_evaluate_id;
    }

    public void setTemplate_evaluate_id(int template_evaluate_id) {
        this.template_evaluate_id = template_evaluate_id;
    }

    public int getPerson_review_id() {
        return person_review_id;
    }

    public void setPerson_review_id(int person_review_id) {
        this.person_review_id = person_review_id;
    }
}
