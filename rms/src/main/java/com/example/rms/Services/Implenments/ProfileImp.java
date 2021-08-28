package com.example.rms.Services.Implenments;

import com.example.rms.Entity.Profile;
import com.example.rms.Repositories.ProfileRepository;
import com.example.rms.Services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileImp implements ProfileService {
    @Autowired
    private ProfileRepository profileRepository;
    public  ProfileImp(ProfileRepository profileRepository){
        this.profileRepository = profileRepository;
    }

    @Override
    public List<Profile> findAll() {
        return profileRepository.findAll();
    }

    @Override
    public Optional<Profile> findAllbyID(Integer id) {
        return this.profileRepository.findById(id);
    }

    @Override
    public void save(Profile profile) {
        this.profileRepository.save(profile);
    }

    @Override
    public void remove(Profile profile) {
        this.profileRepository.deleteAll();
    }

    @Override
    public void deletebyid(Integer id) {
        this.profileRepository.deleteById(id);
    }
}
