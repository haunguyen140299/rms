package com.example.rms.Services.Implenments;

import com.example.rms.Entity.Course;
import com.example.rms.Repositories.CourseRepository;
import com.example.rms.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseImp implements CourseService {
    @Autowired
    private CourseRepository courseRepository;
    public CourseImp(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }


    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> findAllbyID(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(Course course) {

    }

    @Override
    public void remove(Course course) {

    }

    @Override
    public void deletebyid(Integer id) {

    }
}
