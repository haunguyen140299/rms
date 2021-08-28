package com.example.rms.Services.Implenments;

import com.example.rms.Entity.Subject;
import com.example.rms.Repositories.SubjectRepository;
import com.example.rms.Services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class SubjectImp implements SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;
    public SubjectImp(SubjectRepository subjectRepository){
        this.subjectRepository = subjectRepository;
    }

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Optional<Subject> findAllbyID(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(Subject subject) {
        this.subjectRepository.save(subject);
    }

    @Override
    public void remove(Subject subject) {
        this.subjectRepository.delete(subject);
    }

    @Override
    public void deletebyid(Integer id) {
        this.subjectRepository.deleteById(id);
    }
}
