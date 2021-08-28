package com.example.rms.Services;

import com.example.rms.Entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Course> findAll();

    Optional<Course> findAllbyID(Integer id);

    void save(Course course);

    void remove(Course course);

    void deletebyid( Integer id);
}
