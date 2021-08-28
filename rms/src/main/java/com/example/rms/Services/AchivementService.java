package com.example.rms.Services;

import com.example.rms.DTO.AchivementDTO;
import com.example.rms.Entity.Achievements;

import java.util.List;
import java.util.Optional;

public interface AchivementService {
    void save(Achievements achievements);

    void remove(Achievements achievements);

    void deletebyid( Integer id);
    void createAchievements(AchivementDTO achivementDTO);

    List<Achievements> findAllByProfile_id(Integer id);
    Optional<Achievements> findIDAchivement(Integer id);
}
