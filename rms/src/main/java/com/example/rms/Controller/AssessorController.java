package com.example.rms.Controller;

import com.example.rms.Entity.Assessor;
import com.example.rms.Entity.Evaluation;
import com.example.rms.Entity.Student;
import com.example.rms.Services.AssessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/assessor")
public class AssessorController {
    @Autowired
    private AssessorService assessorService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Assessor> addassessor(@RequestBody Assessor assessor, UriComponentsBuilder builder){
        assessorService.save(assessor);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("assessor/{id}")
        .buildAndExpand(assessor.getAssessor_id()).toUri());
        return new ResponseEntity<>(assessor, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<Assessor>> listassessor(){
        List<Assessor> assessors = assessorService.findAll();
        if (assessors.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(assessors, HttpStatus.OK);
    }

    /** API lấy asessor theo id evaluation*/
    @RequestMapping(value = "/listbyidevaluation/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Assessor>> listevaluationbyidevaluation(@PathVariable Integer id){
        List<Assessor> assessors = assessorService.findAllbyidevaluation(id);
        if (assessors.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(assessors, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{idassessor}/{idevaluation}", method = RequestMethod.GET)
    public void addassessor(@PathVariable Integer idassessor,@PathVariable Integer idevaluation){
        assessorService.deleteresult(idassessor,idevaluation);
        assessorService.deletebyidassessor(idassessor,idevaluation);
    }
}
