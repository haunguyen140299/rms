package com.example.rms.Services.Implenments;

import com.example.rms.Entity.Student;
import com.example.rms.Repositories.StudentRepository;
import com.example.rms.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentImp implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public StudentImp(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return this.studentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        this.studentRepository.save(student);
    }

    @Override
    public void remove(Student student) {
        this.studentRepository.delete(student);
    }

    @Override
    public void deletebyid(Integer id) {
        this.studentRepository.deleteById(id);
    }

    @Override
    public List<Student> findAllbyidevaluation(Integer id) {
        return studentRepository.findAllbyidevaluation(id);
    }

    @Override
    public Float avgstudent(Integer id, Integer idevaluation) {
        return studentRepository.avgstudent(id,idevaluation);
    }

    @Override
    public void deleteresult(Integer idassessor, Integer idevaluation) {
        this.studentRepository.deleteresult(idassessor,idevaluation);
    }

    @Override
    public void deletebyidstudent(Integer idassessor, Integer idevaluation) {
        this.studentRepository.deletebyidstudent(idassessor,idevaluation);
    }
}
