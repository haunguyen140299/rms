package com.example.rms.Controller;

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
@CrossOrigin(origins = "*")
@RequestMapping("/results")
public class ResultsController {
    @Autowired
    private ResultService resultService;


//    /** API thêm kết quả */
//    @RequestMapping(value="/add", method = RequestMethod.POST)
//    public ResponseEntity<Results> addresult(@RequestBody Results results, UriComponentsBuilder builder){
//        resultService.save(results);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(builder.path("result/{id}")
//                .buildAndExpand(results.getEvaluation_id()).toUri());
//        return new ResponseEntity<>(results, HttpStatus.CREATED);
//    }
    /** API thêm kết quả */
    @RequestMapping(value="/add", method = RequestMethod.POST)
    public void addresult(@RequestBody Results results){
        resultService.save(results);
    }
    /** API lấy kết quả  */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<Results>> listresult(){
        List<Results> results = resultService.findAll();
        if (results.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(results, HttpStatus.OK);
    }
    /** API lấy kết quả theo id  */
    @RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Results>> listresultbyid(@PathVariable int id){
        List<Results> results = resultService.findlistresultbyIDevaluation(id);
        if (results.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(results, HttpStatus.OK);
    }
    /** API cập nhật kết quả theo id  */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<Results> updateresult(@RequestBody Results results, UriComponentsBuilder builder){
        Results rl = resultService.findbyid(results.getResult_id());
        rl.setContent(results.getContent());
        rl.setScore(results.getScore());
        resultService.save(rl);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("result/{id}")
                .buildAndExpand(results.getEvaluation_id()).toUri());
        return new ResponseEntity<>(results, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/delete/{idevaluation}", method = RequestMethod.GET)
    public void deleteresult(@PathVariable Integer idevaluation){
        resultService.deleteresult(idevaluation);
    }
}
