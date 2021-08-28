package com.example.rms.Entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "evaluation")
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int evaluation_id;
    private String evaluationname;
    private int creater_id;
    private Date day_create;
    private int template_evaluate_id;
    private int assessor_id;
    private int student_id;
    public Evaluation() {
    }

    public int getEvaluation_id() {
        return evaluation_id;
    }

    public void setEvaluation_id(int evaluation_id) {
        this.evaluation_id = evaluation_id;
    }

    public String getEvaluationname() {
        return evaluationname;
    }

    public void setEvaluationname(String evaluationname) {
        this.evaluationname = evaluationname;
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

    public int getAssessor_id() {
        return assessor_id;
    }

    public void setAssessor_id(int assessor_id) {
        this.assessor_id = assessor_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public Evaluation(int evaluation_id, String evaluationname, int creater_id, Date day_create, int template_evaluate_id, int assessor_id, int student_id) {
        this.evaluation_id = evaluation_id;
        this.evaluationname = evaluationname;
        this.creater_id = creater_id;
        this.day_create = day_create;
        this.template_evaluate_id = template_evaluate_id;
        this.assessor_id = assessor_id;
        this.student_id = student_id;
    }
}
