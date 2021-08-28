package com.example.rms.Services.Implenments;

import com.example.rms.DTO.AchivementDTO;
import com.example.rms.Entity.Achievements;
import com.example.rms.Repositories.AchivevementsRepository;
import com.example.rms.Services.AchivementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AchievementImp implements AchivementService {
    @Autowired
    private AchivevementsRepository achivevements_repository;
    public AchievementImp(AchivevementsRepository achivevements_repository){
        this.achivevements_repository = achivevements_repository;
    }
    @Override
    public void save(Achievements achievements) {
        this.achivevements_repository.save(achievements);
    }

    @Override
    public void remove(Achievements achievements) {
        this.achivevements_repository.delete(achievements);
    }

    @Override
    public void deletebyid(Integer id) {
        this.achivevements_repository.deleteById(id);
    }

    @Override
    public void createAchievements(AchivementDTO achivementDTO) {
        achivevements_repository.createAchivement(
                achivementDTO.getImage(),
                achivementDTO.getName_achi(),
                achivementDTO.getTime_achi(),
                achivementDTO.getProfile_id(),
                achivementDTO.getAchievements_id()
        );
    }

    @Override
    public List<Achievements> findAllByProfile_id(Integer id) {
        return  achivevements_repository.findAllByIdProfile(id);
    }

    @Override
    public Optional<Achievements> findIDAchivement(Integer id) {
        return this.achivevements_repository.findById(id);
    }
}
