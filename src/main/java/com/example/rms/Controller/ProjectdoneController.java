package com.example.rms.Controller;

import com.example.rms.DTO.ProjectdoneDTO;
import com.example.rms.Entity.ProjectDone;
import com.example.rms.Entity.StudyProcess;
import com.example.rms.Services.ProjectdoneService;
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
@RequestMapping("/projectdone")
public class ProjectdoneController {
    @Autowired
    private ProjectdoneService projectdone_service;

    /**
     * Dung de them moi
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createAchivements(@Valid @RequestBody ProjectdoneDTO projectdoneDTO, UriComponentsBuilder ucBuilder) {
        projectdone_service.createProjectdone(projectdoneDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(projectdoneDTO.getProject_done_id()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    /**
     * Dung de tim kiem studyprocess theo id profile
     * */
    @RequestMapping(value = "/findbyid/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProjectDone> Findallbyid(@PathVariable Integer id) {
        try {
            List<ProjectDone> projectDones = (List<ProjectDone>) projectdone_service.findAllByProfile_id(id);
            return new ResponseEntity(projectDones, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<ProjectDone>(HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping( value = "/deletebyid/{id}", method = RequestMethod.DELETE)
    public  void Delete(@PathVariable Integer id){
        projectdone_service.deletebyid(id);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?>Edit(@RequestBody ProjectDone projectDone, @PathVariable Integer id){
        try{
            ProjectDone projectDone1 = projectdone_service.findAllbyID(id).get();
            projectDone1.setName_project(projectDone.getName_project());
            projectDone1.setTime_project(projectDone.getTime_project());
            projectDone1.setTeamsize(projectDone.getTeamsize());
            projectDone1.setTechnical(projectDone.getTechnical());
            projectDone1.setDecription(projectDone.getDecription());
            projectdone_service.save(projectDone1);
            return  new ResponseEntity<>(HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
