package com.example.rms.Controller;
import com.example.rms.Entity.Evaluation;
import com.example.rms.Entity.Student;
import com.example.rms.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /** API thêm student*/
    @RequestMapping(value="/add", method = RequestMethod.POST)
    public ResponseEntity<Student> addstudent(@RequestBody Student student, UriComponentsBuilder builder){
        studentService.save(student);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("student/{id}")
                .buildAndExpand(student.getEvaluation_id()).toUri());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }
    /** API lấy student */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> listevaluation(){
        List<Student> students = studentService.findAll();
        if (students.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    /** API lấy student theo id evaluation*/
    @RequestMapping(value = "/listbyidevaluation/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> listevaluationbyidevaluation(@PathVariable Integer id){
        List<Student> students = studentService.findAllbyidevaluation(id);
        if (students.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    /** API lấy điểm trung bình theo id student*/
    @RequestMapping(value = "/avg/{idstudent}/{idevaluation}", method = RequestMethod.GET)
    public ResponseEntity<Float> avgstudent(@PathVariable Integer idstudent,@PathVariable Integer idevaluation){
        Float students = studentService.avgstudent(idstudent,idevaluation);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{idstudent}/{idevaluation}", method = RequestMethod.GET)
    public void deletestudent(@PathVariable Integer idstudent,@PathVariable Integer idevaluation){
        studentService.deleteresult(idstudent,idevaluation);
        studentService.deletebyidstudent(idstudent,idevaluation);
    }
}
