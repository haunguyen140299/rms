package com.example.rms.Services.Implenments;

import com.example.rms.Entity.TemplateEvaluation;
import com.example.rms.Repositories.TemplateEvaluationRepository;
import com.example.rms.Services.TemplateEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TemplateEvaluationImp implements TemplateEvaluationService {
    @Autowired
    private TemplateEvaluationRepository templateEvaluationRepository;
    public TemplateEvaluationImp(TemplateEvaluationRepository templateEvaluationRepository){
        this.templateEvaluationRepository = templateEvaluationRepository;
    }

    @Override
    public List<TemplateEvaluation> findAll() {
        return templateEvaluationRepository.findAll();
    }

    @Override
    public Optional<TemplateEvaluation> findAllbyID(Integer id) {
        return templateEvaluationRepository.findById(id);
    }

    @Override
    public void save(TemplateEvaluation templateEvaluation) {
        templateEvaluationRepository.save(templateEvaluation);
    }

    @Override
    public void remove(TemplateEvaluation templateEvaluation) {
        templateEvaluationRepository.delete(templateEvaluation);
    }

    @Override
    public void deletebyid(Integer id) {
        templateEvaluationRepository.deleteById(id);
    }
}
