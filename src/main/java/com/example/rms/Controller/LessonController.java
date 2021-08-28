package com.example.rms.Controller;

import com.example.rms.Entity.Lesson;
import com.example.rms.Entity.Subject;
import com.example.rms.Repositories.LessonRepository;
import com.example.rms.Repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/lesson")
public class LessonController {
    @Autowired
    LessonRepository lessonRepository;

    @RequestMapping(value = "/addlesson", method = RequestMethod.POST)
    public ResponseEntity<Lesson> addlesson(@RequestBody Lesson lesson, UriComponentsBuilder builder){
        lessonRepository.save(lesson);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/lesson/{id}")
                .buildAndExpand(lesson.getId()).toUri());
        return new ResponseEntity<>(lesson, HttpStatus.CREATED);
    }
}
