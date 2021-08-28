package com.example.rms.Entity;

import javax.persistence.*;

@Entity
@Table(name = "results")
public class Results {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int result_id;
    private int evaluation_id;
    private int student_id;
    private int assessor_id;
    private int evaluation_criteria_id;
    private float score;
    private String content;

    public Results() {
    }

    public Results(int result_id, int evaluation_id, int student_id, int assessor_id, int evaluation_criteria_id, float score, String content) {
        this.result_id = result_id;
        this.evaluation_id = evaluation_id;
        this.student_id = student_id;
        this.assessor_id = assessor_id;
        this.evaluation_criteria_id = evaluation_criteria_id;
        this.score = score;
        this.content = content;
    }

    public int getResult_id() {
        return result_id;
    }

    public void setResult_id(int result_id) {
        this.result_id = result_id;
    }

    public int getEvaluation_id() {
        return evaluation_id;
    }

    public void setEvaluation_id(int evaluation_id) {
        this.evaluation_id = evaluation_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getAssessor_id() {
        return assessor_id;
    }

    public void setAssessor_id(int assessor_id) {
        this.assessor_id = assessor_id;
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
}
