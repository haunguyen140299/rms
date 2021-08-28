package com.example.rms.Services;

import com.example.rms.Entity.Account;
import com.example.rms.Entity.Classes;

import java.util.List;
import java.util.Optional;

public interface ClassesService {
    List<Classes> findAll();

    Optional<Classes> findAllbyID(Integer id);

    void save(Classes classes);

    void remove(Classes classes);

    void deletebyid( Integer id);
}
