package com.example.rms.Controller;

import com.example.rms.Entity.Evaluation;
import com.example.rms.Entity.Profile;
import com.example.rms.Repositories.EvaluationRepository;
import com.example.rms.Services.EvaluationService;
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
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/evaluation")
public class EvaluationController {
    @Autowired
    private EvaluationService evaluationService;

    @Autowired
    private EvaluationRepository evaluationRepository;


    /** API thêm tiêu chí đánh giá */
    @RequestMapping(value="/add", method = RequestMethod.POST)
    public ResponseEntity<Evaluation> addevaluation(@RequestBody Evaluation evaluation, UriComponentsBuilder builder){
        evaluation.setAssessor_id(evaluation.getAssessor_id()+1);
        evaluation.setStudent_id(evaluation.getStudent_id()+1);
        evaluationService.save(evaluation);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("evaluation/{id}")
        .buildAndExpand(evaluation.getEvaluation_id()).toUri());
        return new ResponseEntity<>(evaluation, HttpStatus.CREATED);
    }
    /** API lấy tiêu chí đánh giá  */
    @GetMapping(value = "/all",  params = {"page", "size"})
    public Page<Object> getAll(@RequestParam("page") int page,
                                                   @RequestParam("size") int size,
                                               @RequestParam("search") String search
                                                   )
    {
            String search1 = "%" + search + "%";
            Pageable paging = PageRequest.of(page, size);
            return evaluationRepository.findAllByEvaluationname1(search1,paging);
    }
    /** API lấy tiêu chí đánh giá theo id  */
    @RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Evaluation>> listevaluationbyid(@PathVariable int id){
        Optional<Evaluation> evaluation = evaluationService.findAllbyID(id);
        if (evaluation.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(evaluation, HttpStatus.OK);
    }

    @RequestMapping(value="/updatename", method = RequestMethod.POST)
    public void Editname(@RequestBody Evaluation evaluation ) {
            Evaluation ev = evaluationService.findAllbyID(evaluation.getEvaluation_id()).get();
            ev.setEvaluationname(evaluation.getEvaluationname());
            evaluationService.save(ev);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        evaluationService.deletebyid(id);
    }
}
