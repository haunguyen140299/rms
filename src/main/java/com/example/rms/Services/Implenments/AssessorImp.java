package com.example.rms.Services.Implenments;

import com.example.rms.Entity.Assessor;
import com.example.rms.Repositories.AssessorRepository;
import com.example.rms.Services.AssessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssessorImp implements AssessorService {
    @Autowired
    private AssessorRepository assessorRepository;
    public AssessorImp(AssessorRepository assessorRepository){
        this.assessorRepository = assessorRepository;
    }

    @Override
    public List<Assessor> findAll() {
        return this.assessorRepository.findAll();
    }

    @Override
    public Optional<Assessor> findAllbyID(Integer id) {
        return this.assessorRepository.findById(id);
    }

    @Override
    public void save(Assessor assessor) {
        this.assessorRepository.save(assessor);
    }

    @Override
    public void remove(Assessor assessor) {
        this.assessorRepository.delete(assessor);
    }

    @Override
    public void deletebyid(Integer id) {
        this.assessorRepository.deleteById(id);
    }

    @Override
    public List<Assessor> findAllbyidevaluation(Integer id) {
        return assessorRepository.findAllbyidevaluation(id);
    }

    @Override
    public void deleteresult(Integer idassessor,Integer idevaluation) {
        this.assessorRepository.deleteresult(idassessor,idevaluation);
    }

    @Override
    public void deletebyidassessor(Integer idassessor,Integer idevaluation) {
        this.assessorRepository.deletebyidassessor(idassessor,idevaluation);
    }
}
