package com.example.rms.Services.Implenments;

import com.example.rms.Entity.Results;
import com.example.rms.Services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/result")
public class ResultController {
    @Autowired
    private ResultService resultService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Results> addassessor(@RequestBody Results results, UriComponentsBuilder builder){
        resultService.save(results);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("assessor/{id}")
                .buildAndExpand(results.getAssessor_id()).toUri());
        return new ResponseEntity<>(results, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<Results>> listassessor(){
        List<Results> results = resultService.findAll();
        if (results.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(results, HttpStatus.OK);
    }
}
