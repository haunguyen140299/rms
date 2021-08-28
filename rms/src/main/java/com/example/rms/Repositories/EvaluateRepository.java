package com.example.rms.Repositories;


import com.example.rms.Entity.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface EvaluateRepository extends JpaRepository<Evaluation, Integer> {
    @Query(value = "SELECT type_id from evaluationcriteria where evaluate_criteria_id = ?1",nativeQuery = true)
    int gettype(int eva_cri_id);
}
