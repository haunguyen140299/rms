package com.example.rms.Entity;


import javax.persistence.*;

@Entity
@Table(name="evaluationcriteria")
public class EvaluationCriteria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int template_evaluation_id;
    private String evaluate_criteria_name;
    private int type_id;
    private int evaluation_id;

    public EvaluationCriteria() {
    }

    public EvaluationCriteria(int id, int template_evaluation_id, String evaluate_criteria_name, int type_id, int evaluation_id) {
        this.id = id;
        this.template_evaluation_id = template_evaluation_id;
        this.evaluate_criteria_name = evaluate_criteria_name;
        this.type_id = type_id;
        this.evaluation_id = evaluation_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTemplate_evaluation_id() {
        return template_evaluation_id;
    }

    public void setTemplate_evaluation_id(int template_evaluation_id) {
        this.template_evaluation_id = template_evaluation_id;
    }

    public String getEvaluate_criteria_name() {
        return evaluate_criteria_name;
    }

    public void setEvaluate_criteria_name(String evaluate_criteria_name) {
        this.evaluate_criteria_name = evaluate_criteria_name;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public int getEvaluation_id() {
        return evaluation_id;
    }

    public void setEvaluation_id(int evaluation_id) {
        this.evaluation_id = evaluation_id;
    }
}