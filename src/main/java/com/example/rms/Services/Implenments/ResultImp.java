package com.example.rms.Services.Implenments;

import com.example.rms.Entity.Results;
import com.example.rms.Repositories.ResultRepository;
import com.example.rms.Services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultImp implements ResultService {
    @Autowired
    private ResultRepository resultRepository;
    public ResultImp(ResultRepository resultRepository){
        this.resultRepository = resultRepository;
    }
    @Override
    public List<Results> findAll() {
        return this.resultRepository.findAll();
    }

    @Override
    public List<Results> findlistresultbyIDevaluation(Integer id) {
        return this.resultRepository.findlistresultbyIDevaluation(id);
    }

    @Override
    public void save(Results results) {
        this.resultRepository.save(results);
    }

    @Override
    public void remove(Results results) {
        this.resultRepository.delete(results);
    }

    @Override
    public void deletebyid(Integer id) {
        this.resultRepository.deleteById(id);
    }

    @Override
    public Results findbyid(Integer id) {
        return this.resultRepository.findbyid(id);
    }

    @Override
    public void deleteresult(Integer id) {
        this.resultRepository.deletebyevaluation(id);
    }
}
