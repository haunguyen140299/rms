package com.example.rms.Services;

import com.example.rms.DTO.EvaluationCriteriaDTO;
import com.example.rms.Entity.EvaluationCriteria;
import org.springframework.data.relational.core.sql.Table;
import springfox.documentation.spring.web.json.Json;

import java.sql.Array;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public interface EvaluationCriteriaService {
    List<EvaluationCriteria> findAll();

    Optional<EvaluationCriteria> findAllbyID(Integer id);

    List<EvaluationCriteria> findID(Integer id);

    void save(EvaluationCriteria evaluationCriteria);

    void remove(EvaluationCriteria evaluationCriteria);

    void deletebyid( Integer id);

    List<Object> findAllevacritebyIDevaluation(Integer id, Integer id_assessor);

    List<Object> findAllresultstudentbyIDevaluation(Integer id,Integer id_student);

}
