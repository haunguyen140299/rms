package com.example.rms.Services;
import com.example.rms.Entity.Results;

import java.util.List;

public interface ResultService {
    List<Results> findAll();

    List<Results> findlistresultbyIDevaluation(Integer id);

    void save(Results results);

    void remove(Results results);

    void deletebyid( Integer id);

    Results findbyid(Integer id);

    void deleteresult(Integer id);
}
