package com.example.rms.Controller;

import com.example.rms.Entity.EvaluationCriteria;
import com.example.rms.Entity.TemplateEvaluation;
import com.example.rms.Repositories.TemplateEvaluationRepository;
import com.example.rms.Services.TemplateEvaluationService;
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
@RequestMapping("/template")
public class TemplateEvaluationController {
    @Autowired
    private TemplateEvaluationService templateEvaluationService;
    @Autowired
    private TemplateEvaluationRepository templateEvaluationRepository;

    @GetMapping(value = "/findall",  params = {"page", "size"})
    public Page<Object> getAll(@RequestParam("page") int page,
                               @RequestParam("size") int size,
                               @RequestParam("search") String search
    )
    {
        String search1 = "%" + search + "%";
        Pageable paging = PageRequest.of(page, size);
        return templateEvaluationRepository.findAllBytemplate(search1,paging);
    }

    /** API thêm tiêu mẫu đánh giá */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
        public ResponseEntity<TemplateEvaluation> addtemplate(@RequestBody TemplateEvaluation templateEvaluation, UriComponentsBuilder builder){
        templateEvaluationService.save(templateEvaluation);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/templates/{id}")
                .buildAndExpand(templateEvaluation.getTemplate_evaluation_id()).toUri());
        return new ResponseEntity<>(templateEvaluation, HttpStatus.CREATED);
    }
    /** API lấy dánh sách mẫu đánh giá */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<TemplateEvaluation>> findAllProduct() {
        List<TemplateEvaluation> templates = templateEvaluationService.findAll();
        if (templates.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(templates, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        templateEvaluationService.deletebyid(id);
    }
}
