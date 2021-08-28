package com.example.rms.Services;

import com.example.rms.Entity.Mentor;

import java.util.List;
import java.util.Optional;

public interface MentorService {
    List<Mentor> findAll();

    Optional<Mentor> findAllbyID(Integer id);

    void save(Mentor mentor);

    void remove(Mentor mentor);

    void deletebyid(Integer id);
}
