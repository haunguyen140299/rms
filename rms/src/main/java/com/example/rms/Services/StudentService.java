package com.example.rms.Services;

import com.example.rms.Entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> findAll();

    void save(Student student);

    void remove(Student student);

    void deletebyid( Integer id);

    List<Student> findAllbyidevaluation(Integer id);

    Float avgstudent(Integer idstudent, Integer idevaluation);

    void deleteresult(Integer idassessor,Integer idevaluation);

    void deletebyidstudent( Integer idassessor,Integer idevaluation);
}
