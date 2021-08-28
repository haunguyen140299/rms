package com.example.rms.Services.Implenments;

import com.example.rms.Entity.Teacher;
import com.example.rms.Repositories.TeacherRepository;
import com.example.rms.Services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherImp implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;
    public TeacherImp(TeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Optional<Teacher> findAllbyID(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(Teacher teacher) {
        this.teacherRepository.save(teacher);
    }

    @Override
    public void remove(Teacher teacher) {
        this.teacherRepository.delete(teacher);
    }

    @Override
    public void deletebyid(Integer id) {
        this.teacherRepository.deleteById(id);
    }
}
