package com.example.rms.Controller;

import com.example.rms.DTO.AchivementDTO;
import com.example.rms.DTO.StudyprocessDTO;
import com.example.rms.Entity.Achievements;
import com.example.rms.Services.AchivementService;
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
@RequestMapping("/achievments")
public class AchievementsController {
    @Autowired
    private AchivementService achivement_service;

    /**
     * Dung de them moi
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createAchivements(@Valid @RequestBody AchivementDTO achivementDTO, UriComponentsBuilder ucBuilder) {
        achivement_service.createAchievements(achivementDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(achivementDTO.getAchievements_id()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }


    /**
     * Dung de tim kiem  theo id profile
     * */
    @RequestMapping(value = "/findbyid/{id}", method = RequestMethod.GET)
    public ResponseEntity<Achievements> Findallbyid(@PathVariable Integer id) {
        try {
            List<Achievements> achievements = (List<Achievements>) achivement_service.findAllByProfile_id(id);
            return new ResponseEntity(achievements, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Achievements>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?>Edit(@RequestBody Achievements achievements, @PathVariable Integer id){
        try{
            Achievements achievements1 = achivement_service.findIDAchivement(id).get();
            achievements1.setName_achi(achievements.getName_achi());
            achievements1.setTime_achi(achievements.getTime_achi());
            achievements1.setImage(achievements.getImage());
            achivement_service.save(achievements1);
            return  new ResponseEntity<>(HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping( value = "/deletebyid/{id}", method = RequestMethod.DELETE)
    public  void Delete(@PathVariable Integer id){
        achivement_service.deletebyid(id);
    }

}
