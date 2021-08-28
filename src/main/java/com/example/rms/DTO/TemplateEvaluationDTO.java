package com.example.rms.DTO;

import java.util.Date;

public class TemplateEvaluationDTO {
    private int template_evaluation_id;
    private String template_evaluation_name;
    private int creater_id;
    private Date day_of_create;

    public TemplateEvaluationDTO(int template_evaluation_id, String template_evaluation_name, int creater_id, Date day_of_create) {
        this.template_evaluation_id = template_evaluation_id;
        this.template_evaluation_name = template_evaluation_name;
        this.creater_id = creater_id;
        this.day_of_create = day_of_create;
    }

    public TemplateEvaluationDTO() {
    }

    public int getTemplate_evaluation_id() {
        return template_evaluation_id;
    }

    public void setTemplate_evaluation_id(int template_evaluation_id) {
        this.template_evaluation_id = template_evaluation_id;
    }

    public String getTemplate_evaluation_name() {
        return template_evaluation_name;
    }

    public void setTemplate_evaluation_name(String template_evaluation_name) {
        this.template_evaluation_name = template_evaluation_name;
    }

    public int getCreater_id() {
        return creater_id;
    }

    public void setCreater_id(int creater_id) {
        this.creater_id = creater_id;
    }

    public Date getDay_of_create() {
        return day_of_create;
    }

    public void setDay_of_create(Date day_of_create) {
        this.day_of_create = day_of_create;
    }
}
