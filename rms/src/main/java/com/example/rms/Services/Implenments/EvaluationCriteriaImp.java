package com.example.rms.Services.Implenments;

import com.example.rms.DTO.EvaluationCriteriaDTO;
import com.example.rms.Entity.EvaluationCriteria;
import com.example.rms.Repositories.EvaluationCriteriaRepository;
import com.example.rms.Repositories.EvaluationRepository;
import com.example.rms.Services.EvaluationCriteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.Table;
import org.springframework.stereotype.Service;
import springfox.documentation.spring.web.json.Json;

import java.sql.Array;
import java.util.List;
import java.util.Optional;
@Service
public class EvaluationCriteriaImp implements EvaluationCriteriaService {
    @Autowired
    private EvaluationCriteriaRepository evaluationCriteriaRepository;
    public EvaluationCriteriaImp(EvaluationCriteriaRepository evaluationCriteriaRepository){
        this.evaluationCriteriaRepository = evaluationCriteriaRepository;
    }

    @Override
    public List<EvaluationCriteria> findAll() {
        return evaluationCriteriaRepository.findAll();
    }

    @Override
    public Optional<EvaluationCriteria> findAllbyID(Integer id) {
        return evaluationCriteriaRepository.findById(id);
    }

    @Override
    public void save(EvaluationCriteria evaluationCriteria) {
        evaluationCriteriaRepository.save(evaluationCriteria);
    }

    @Override
    public void remove(EvaluationCriteria evaluationCriteria) {
        evaluationCriteriaRepository.delete(evaluationCriteria);
    }

    @Override
    public void deletebyid(Integer id) {
        evaluationCriteriaRepository.deleteById(id);
    }

    @Override
    public List<Object> findAllevacritebyIDevaluation(Integer id, Integer id_assessor) {
        return evaluationCriteriaRepository.findAllevacritebyIDevaluation(id,id_assessor);
    }

    @Override
    public List<Object> findAllresultstudentbyIDevaluation(Integer id, Integer id_student) {
        return evaluationCriteriaRepository.findAllresultstudentbyIDevaluation(id,id_student);
    }

    @Override
    public List<EvaluationCriteria> findID(Integer id){
        return evaluationCriteriaRepository.findID(id);
    }
}
