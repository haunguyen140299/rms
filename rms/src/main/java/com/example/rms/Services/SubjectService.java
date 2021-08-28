package com.example.rms.Services;

import com.example.rms.Entity.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectService {
    List<Subject> findAll();

    Optional<Subject> findAllbyID(Integer id);

    void save(Subject subject);

    void remove(Subject subject);

    void deletebyid(Integer id);
}
