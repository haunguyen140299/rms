package com.example.rms.Services;

import com.example.rms.Entity.Evaluation;

import java.util.List;
import java.util.Optional;

public interface EvaluationService {
    List<Evaluation> findAll();

    Optional<Evaluation> findAllbyID(Integer id);

    void save(Evaluation evaluation);

    void remove(Evaluation evaluation);

    void deletebyid( Integer id);
}
