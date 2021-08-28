package com.example.rms.Controller;

import com.example.rms.DTO.EvaluationCriteriaDTO;
import com.example.rms.Entity.Account;
import com.example.rms.Entity.EvaluationCriteria;
import com.example.rms.Services.EvaluationCriteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.Table;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import springfox.documentation.spring.web.json.Json;

import java.sql.Array;
import java.util.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/evaluationcriteria")
public class EvaluationCriteriaController {
    @Autowired
    private EvaluationCriteriaService evaluationCriteriaService;

    /** API thêm tiêu chí đánh giá */
    @RequestMapping(value="/add", method = RequestMethod.POST)
    public ResponseEntity<EvaluationCriteria> addevaluationcriteria(@RequestBody EvaluationCriteria evaluationCriteria, UriComponentsBuilder builder){
        evaluationCriteriaService.save(evaluationCriteria);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(builder.path("/evaluationCriteria/{id}")
                .buildAndExpand(evaluationCriteria.getTemplate_evaluation_id()).toUri());
        return new ResponseEntity<>(evaluationCriteria, HttpStatus.CREATED);
    }
    /** API lấy tiêu chí đánh giá  */
    @RequestMapping(value="/list", method = RequestMethod.GET)
    public ResponseEntity<List<EvaluationCriteria>> listevaluationcriteria(){
        List<EvaluationCriteria> evaluationcriteria = evaluationCriteriaService.findAll();
        if (evaluationcriteria.isEmpty()) {
               return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(evaluationcriteria, HttpStatus.OK);
    }

    /** API lấy tiêu chí đánh giá theo ID */
    @RequestMapping(value="/list/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<EvaluationCriteria>> getevaluationcriteria(@PathVariable int id){
        List<EvaluationCriteria> evaluationCriteria = evaluationCriteriaService.findID(id);
        if (evaluationCriteria.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(evaluationCriteria,HttpStatus.OK);
    }
    /** API lấy tiêu chí đánh giá theo id đánh giá */
    @RequestMapping(value = "/listevacrite/{id}/{id_assessor}", method = RequestMethod.GET)
    public ResponseEntity<List<Object>> listevacrite(@PathVariable int id, @PathVariable int id_assessor){
        List<Object> evaluationCriteria = evaluationCriteriaService.findAllevacritebyIDevaluation(id,id_assessor);
        return new ResponseEntity<>(evaluationCriteria, HttpStatus.OK);
    }
    /** API lấy kết quả học sinh theo id đánh giá */
    @RequestMapping(value = "/listeresultstudent/{id}/{id_student}", method = RequestMethod.GET)
    public ResponseEntity<List<Object>> listresultstudent(@PathVariable Integer id, @PathVariable Integer id_student){
        List<Object> evaluationCriteria = evaluationCriteriaService.findAllresultstudentbyIDevaluation(id,id_student);
        return new ResponseEntity<>(evaluationCriteria, HttpStatus.OK);
    }
}
