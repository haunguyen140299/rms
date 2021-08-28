package com.example.rms.Services;

import com.example.rms.Entity.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
    List<Teacher> findAll();

    Optional<Teacher> findAllbyID(Integer id);

    void save(Teacher teacher);

    void remove(Teacher teacher);

    void deletebyid(Integer id);
}
