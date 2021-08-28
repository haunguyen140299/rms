package com.example.rms.Repositories;

import com.example.rms.Entity.TemplateEvaluation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TemplateEvaluationRepository extends JpaRepository<TemplateEvaluation, Integer> {
    @Query(value = "SELECT templateevaluation.template_evaluation_id,templateevaluation.day_of_create,templateevaluation.template_evaluation_name,account.fullname  from templateevaluation,account WHERE templateevaluation.creater_id = account.account_id and template_evaluation_name like ?1", nativeQuery = true)
    Page<Object> findAllBytemplate(String name, Pageable pageable);
}
