package com.example.rms.Services.Implenments;

import com.example.rms.Entity.Classes;
import com.example.rms.Repositories.ClassesRepository;
import com.example.rms.Services.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ClassesImp implements ClassesService {
    @Autowired
    private ClassesRepository classesRepository;
    private ClassesImp(ClassesRepository  classesRepository){
        this.classesRepository = classesRepository;
    }
    @Override
    public List<Classes> findAll() {
            return this.classesRepository.findAll();
    }

    @Override
    public Optional<Classes> findAllbyID(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(Classes classes) {

    }

    @Override
    public void remove(Classes classes) {

    }

    @Override
    public void deletebyid(Integer id) {

    }
}
