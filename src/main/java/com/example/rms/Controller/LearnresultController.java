package com.example.rms.Controller;

import com.example.rms.DTO.LearnresultDTO;
import com.example.rms.Entity.Learnresult;
import com.example.rms.Entity.StudyProcess;
import com.example.rms.Services.LearnresultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/learnresult")
public class LearnresultController {
    @Autowired
    private LearnresultService learnresult_service;

    /**
     * Dung de them moi
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createStudyprocess(@Valid @RequestBody LearnresultDTO learnresultDTO, UriComponentsBuilder ucBuilder) {
        learnresult_service.createLearnresult(learnresultDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(learnresultDTO.getLearn_result_id()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    /**
     * Dung de tim kiem  theo id profile
     * */
    @RequestMapping(value = "/findbyid/{id}", method = RequestMethod.GET)
    public ResponseEntity<Learnresult> Findallbyid(@PathVariable Integer id) {
        try {
            List<Learnresult> learnresults = (List<Learnresult>) learnresult_service.findAllByProfile_id(id);
            return new ResponseEntity(learnresults, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Learnresult>(HttpStatus.NOT_FOUND);
        }
    }
    /**
     * dung de update
    * */
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?>Edit(@RequestBody Learnresult learnresult, @PathVariable Integer id){
        try{
            Learnresult learnresult1 = learnresult_service.findbyID(id).get();
            learnresult1.setName_learn(learnresult.getName_learn());
            learnresult1.setResult_learn(learnresult.getResult_learn());
            learnresult_service.save(learnresult1);
            return  new ResponseEntity<>(HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /**
     * dung de delete
     * */
    @RequestMapping( value = "/deletebyid/{id}", method = RequestMethod.DELETE)
    public  void Delete(@PathVariable Integer id){
        learnresult_service.deletebyid(id);
    }

}
