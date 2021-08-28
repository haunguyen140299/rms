package com.example.rms.Entity;

import javax.persistence.*;

@Entity
@Table(name="assessor")
public class Assessor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int evaluation_id;
    private int assessor_id;

    public Assessor() {
    }

    public Assessor(int id, int evaluation_id, int assessor_id) {
        this.id = id;
        this.evaluation_id = evaluation_id;
        this.assessor_id = assessor_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEvaluation_id() {
        return evaluation_id;
    }

    public void setEvaluation_id(int evaluation_id) {
        this.evaluation_id = evaluation_id;
    }

    public int getAssessor_id() {
        return assessor_id;
    }

    public void setAssessor_id(int assessor_id) {
        this.assessor_id = assessor_id;
    }
}
