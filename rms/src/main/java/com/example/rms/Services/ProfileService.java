package com.example.rms.Services;

import com.example.rms.Entity.Profile;

import java.util.List;
import java.util.Optional;

public interface ProfileService {
    List<Profile> findAll();
    Optional<Profile> findAllbyID(Integer id);

    void save(Profile profile);

    void remove(Profile profile);

    void deletebyid( Integer id);
}
