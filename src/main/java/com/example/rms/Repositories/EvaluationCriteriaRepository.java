package com.example.rms.Repositories;

import com.example.rms.DTO.EvaluationCriteriaDTO;
import com.example.rms.Entity.Account;
import com.example.rms.Entity.EvaluationCriteria;
import com.example.rms.Entity.Results;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.relational.core.sql.Table;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import springfox.documentation.spring.web.json.Json;

import java.sql.Array;
import java.util.List;
import java.util.Objects;

@Repository
@Transactional
public interface EvaluationCriteriaRepository extends JpaRepository<EvaluationCriteria, Integer>{
    @Query(value = "select * from  evaluationcriteria where template_evaluation_id=?1", nativeQuery = true)
    List<EvaluationCriteria> findID(Integer id);
    @Query(value = "SELECT rl.result_id,rl.student_id,rl.evaluation_criteria_id,rl.score,rl.content,ec.evaluate_criteria_name,ec.type_id from results rl inner join evaluationcriteria ec WHERE rl.evaluation_criteria_id = ec.id and rl.evaluation_id = ?1 and rl.assessor_id = ?2", nativeQuery = true)
    List<Object> findAllevacritebyIDevaluation(Integer id,Integer id_assessor);
    @Query(value = "SELECT rl.assessor_id, rl.score,rl.content,ec.evaluate_criteria_name from results rl, evaluationcriteria ec where rl.evaluation_id = ?1 and rl.student_id = ?2 and rl.evaluation_criteria_id = ec.id", nativeQuery = true)
    List<Object> findAllresultstudentbyIDevaluation(Integer id,Integer id_student);
}