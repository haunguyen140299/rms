package com.example.rms.Controller;

import com.example.rms.DTO.StudyprocessDTO;
import com.example.rms.Entity.Achievements;
import com.example.rms.Entity.StudyProcess;
import com.example.rms.Services.StudyprocesService;
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
@RequestMapping("/studyprocess")
@CrossOrigin(origins = "*")
public class StudyprocessController {
    @Autowired
    private StudyprocesService studyproces_service;

    /**
     * Dung de them moi
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createStudyprocess(@Valid @RequestBody StudyprocessDTO studyprocessDTO, UriComponentsBuilder ucBuilder) {
        studyproces_service.createStudyprocess(studyprocessDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(studyprocessDTO.getStudy_process_id()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    /**
     * Dung de tim kiem studyprocess theo id profile
     * */
    @RequestMapping(value = "/findbyid/{id}", method = RequestMethod.GET)
    public ResponseEntity<StudyProcess> Findallbyid(@PathVariable Integer id) {
        try {
            List<StudyProcess> studyProcess = (List<StudyProcess>) studyproces_service.findAllByProfile_id(id);
            return new ResponseEntity(studyProcess, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<StudyProcess>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?>Edit(@RequestBody StudyProcess studyProcess, @PathVariable Integer id){
        try{
            StudyProcess studyProcess1 = studyproces_service.findAllbyID(id).get();
            studyProcess1.setTime_process(studyProcess.getTime_process());
            studyProcess1.setSchool(studyProcess.getSchool());
            studyProcess1.setNote(studyProcess.getNote());
            studyproces_service.save(studyProcess1);
            return  new ResponseEntity<>(HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping( value = "/deletebyid/{id}", method = RequestMethod.DELETE)
    public  void Delete(@PathVariable Integer id){
        studyproces_service.deleteBYID(id);
    }


}
