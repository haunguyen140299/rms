package com.example.rms.Repositories;

import com.example.rms.Entity.Evaluation;
import com.example.rms.Entity.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface EvaluationRepository extends JpaRepository<Evaluation, Integer> {
    @Query(value = "SELECT evaluation.evaluation_id,evaluation.evaluationname,evaluation.creater_id,evaluation.day_create,account.fullname from evaluation , account WHERE evaluation.creater_id = account.account_id and evaluation.evaluationname like ?1", nativeQuery = true)
    Page<Object> findAllByEvaluationname1(String name,Pageable pageable);
}
