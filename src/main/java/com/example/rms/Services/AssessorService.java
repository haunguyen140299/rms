package com.example.rms.Services;

import com.example.rms.Entity.Assessor;

import java.util.List;
import java.util.Optional;

public interface AssessorService {
    List<Assessor> findAll();

    Optional<Assessor> findAllbyID(Integer id);

    void save(Assessor assessor);

    void remove(Assessor assessor);

    void deletebyid( Integer id);

    List<Assessor> findAllbyidevaluation(Integer id);

    void deleteresult(Integer idassessor,Integer idevaluation);

    void deletebyidassessor( Integer idassessor,Integer idevaluation);
}
