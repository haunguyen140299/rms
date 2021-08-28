package com.example.rms.Controller;


import com.example.rms.Entity.Course;
import com.example.rms.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public ResponseEntity<Course> addcourse(@RequestBody Course course, UriComponentsBuilder builder){
        courseService.save(course);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(builder.path("course/{id}")
                .buildAndExpand(course.getCourse_id()).toUri());
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

    @RequestMapping(value="/list", method = RequestMethod.GET)
    public ResponseEntity<List<Course>> listcourse(){
        List<Course> course = courseService.findAll();
        if (course.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(course,HttpStatus.OK);
    }
}
