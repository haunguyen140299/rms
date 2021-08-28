package com.example.rms.Services.Implenments;

import com.example.rms.Entity.Mentor;
import com.example.rms.Repositories.MentorRepository;
import com.example.rms.Services.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MentorImp implements MentorService {
    @Autowired
    private MentorRepository mentorRepository;
    private MentorImp(MentorRepository mentorRepository){
        this.mentorRepository = mentorRepository;
    }

    @Override
    public List<Mentor> findAll() {
        return mentorRepository.findAll();    }

    @Override
    public Optional<Mentor> findAllbyID(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(Mentor Mentor) {

    }

    @Override
    public void remove(Mentor Mentor) {

    }

    @Override
    public void deletebyid(Integer id) {

    }
}
