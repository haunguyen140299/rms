package com.example.rms.DTO;

import javax.persistence.Table;

@Table
public class EvaluationCriteriaDTO {
    private int result_id;
    private int student_id;
    private int evaluation_criteria_id;
    private float score;
    private String content;
    private String evaluate_criteria_name;
    private int type_id;

    public EvaluationCriteriaDTO() {
    }

    public EvaluationCriteriaDTO(int result_id, int student_id, int evaluation_criteria_id, float score, String content, String evaluate_criteria_name, int type_id) {
        this.result_id = result_id;
        this.student_id = student_id;
        this.evaluation_criteria_id = evaluation_criteria_id;
        this.score = score;
        this.content = content;
        this.evaluate_criteria_name = evaluate_criteria_name;
        this.type_id = type_id;
    }

    public int getResult_id() {
        return result_id;
    }

    public void setResult_id(int result_id) {
        this.result_id = result_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getEvaluation_criteria_id() {
        return evaluation_criteria_id;
    }

    public void setEvaluation_criteria_id(int evaluation_criteria_id) {
        this.evaluation_criteria_id = evaluation_criteria_id;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
}
