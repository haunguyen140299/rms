package com.example.rms.Services.Implenments;

import com.example.rms.DTO.LearnresultDTO;
import com.example.rms.Entity.Learnresult;
import com.example.rms.Repositories.LearnresultRepository;
import com.example.rms.Services.LearnresultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LearnresultImp  implements LearnresultService {
    @Autowired
    private LearnresultRepository learnresult_repository;
    public LearnresultImp(LearnresultRepository learnresult_repository){
        this.learnresult_repository = learnresult_repository;
    }

    @Override
    public void save(Learnresult learnresult) {
        this.learnresult_repository.save(learnresult);
    }

    @Override
    public void remove(Learnresult learnresult) {
        this.learnresult_repository.delete(learnresult);
    }

    @Override
    public void deletebyid(Integer id) {
        this.learnresult_repository.deleteById(id);
    }

    @Override
    public void createLearnresult(LearnresultDTO learnresultDTO) {
        learnresult_repository.createLearnresult(
                learnresultDTO.getName_learn(),
                learnresultDTO.getResult_learn(),
                learnresultDTO.getProfile_id(),
                learnresultDTO.getLearn_result_id()
        );
    }

    @Override
    public List<Learnresult> findAllByProfile_id(Integer id) {
        return learnresult_repository.findAllByIdprofile(id);
    }

    @Override
    public Optional<Learnresult> findbyID(Integer id) {
        return learnresult_repository.findById(id);
    }
}
