package com.example.rms.DTO;

public class PersonReviewDTO {
    private int person_review_id;
    private int assessor_id;
    private int student_id;

    public PersonReviewDTO(int person_review_id, int assessor_id, int student_id) {
        this.person_review_id = person_review_id;
        this.assessor_id = assessor_id;
        this.student_id = student_id;
    }

    public PersonReviewDTO() {
    }

    public int getPerson_review_id() {
        return person_review_id;
    }

    public void setPerson_review_id(int person_review_id) {
        this.person_review_id = person_review_id;
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
}
