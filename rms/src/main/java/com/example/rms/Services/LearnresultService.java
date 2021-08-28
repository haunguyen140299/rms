package com.example.rms.Services;

import com.example.rms.DTO.LearnresultDTO;
import com.example.rms.Entity.Learnresult;

import java.util.List;
import java.util.Optional;

public interface LearnresultService {
    void save(Learnresult learnresult);

    void remove(Learnresult learnresult);

    void deletebyid( Integer id);
    void createLearnresult(LearnresultDTO learnresultDTO);

    List<Learnresult> findAllByProfile_id(Integer id);
    Optional<Learnresult> findbyID(Integer id);
}
