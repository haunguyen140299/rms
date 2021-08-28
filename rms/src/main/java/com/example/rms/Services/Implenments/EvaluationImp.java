package com.example.rms.Services.Implenments;

import com.example.rms.Entity.Evaluation;
import com.example.rms.Repositories.EvaluationRepository;
import com.example.rms.Services.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EvaluationImp implements EvaluationService {
    @Autowired
    private EvaluationRepository evaluationRepository;
    public EvaluationImp(EvaluationRepository evaluationRepository){
        this.evaluationRepository = evaluationRepository;
    }
    @Override
    public List<Evaluation> findAll() {
        return evaluationRepository.findAll();
    }

    @Override
    public Optional<Evaluation> findAllbyID(Integer id) {
        return evaluationRepository.findById(id);
    }

    @Override
    public void save(Evaluation evaluation) {
        evaluationRepository.save(evaluation);
    }

    @Override
    public void remove(Evaluation evaluation) {
        evaluationRepository.delete(evaluation);
    }

    @Override
    public void deletebyid(Integer id) {
        evaluationRepository.deleteById(id);
    }
}
