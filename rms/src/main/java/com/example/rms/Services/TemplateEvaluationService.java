package com.example.rms.Services;
import com.example.rms.Entity.TemplateEvaluation;

import java.util.List;
import java.util.Optional;

public interface TemplateEvaluationService {
    List<TemplateEvaluation> findAll();

    Optional<TemplateEvaluation> findAllbyID(Integer id);

    void save(TemplateEvaluation templateEvaluation);

    void remove(TemplateEvaluation templateEvaluation);

    void deletebyid( Integer id);
}
