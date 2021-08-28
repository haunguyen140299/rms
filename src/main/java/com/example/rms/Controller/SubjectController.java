package com.example.rms.Controller;

import com.example.rms.Entity.*;
import com.example.rms.Repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    SubjectRepository subjectRepository;

    @RequestMapping(value = "/addsubject", method = RequestMethod.POST)
    public ResponseEntity<Subject> addtemplate(@RequestBody Subject subject, UriComponentsBuilder builder){
        subjectRepository.save(subject);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/templates/{id}")
                .buildAndExpand(subject.getId_subject()).toUri());
        return new ResponseEntity<>(subject, HttpStatus.CREATED);
    }

    @GetMapping(value = "/allsubject",  params = {"page", "size"})
    public Page<Object> getAll(@RequestParam("page") int page,
                               @RequestParam("size") int size,
                               @RequestParam("search") String search
    )
    {
        String search1 = "%" + search + "%";
        Pageable paging = PageRequest.of(page, size);
        return subjectRepository.findAllevacritebyIDevaluation(search1,paging);
    }


}
