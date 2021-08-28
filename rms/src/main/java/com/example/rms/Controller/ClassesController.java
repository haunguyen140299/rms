package com.example.rms.Controller;

import com.example.rms.Entity.Classes;
import com.example.rms.Entity.Course;
import com.example.rms.Repositories.ClassesRepository;
import com.example.rms.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin (origins = "*")
@RequestMapping(value = "/class")
public class ClassesController {
    @Autowired
    ClassesRepository classesRepository;
    @Autowired
    CourseService courseService;
    /** Đây là cách viết api cũ */
    /** API tạo mới lớp học. */
    @PostMapping("/addclass")
    public void addclass(@RequestBody Classes classes){
        classesRepository.save(classes);
    }
    /** API thêm classes */
    @GetMapping("/course")
    public List<Course> findallcourse(){
        return courseService.findAll();
    }

    /** API lấy danh sách khóa/lớp học  */
    @GetMapping("/getclass/{id}")
    public List<Classes> getbyid(@PathVariable int id){
        return classesRepository.findAllById(Collections.singleton(id));
    }
    /** API lấy tất cả các danh sách khóa/lớp học */
    @GetMapping(value = "/allclass",  params = {"page", "size"})
    public Page<Object> getAll(@RequestParam("page") int page,
                               @RequestParam("size") int size,
                               @RequestParam("search") String search
    )
    {
        String search1 = "%" + search + "%";
        Pageable paging = PageRequest.of(page, size);
        return classesRepository.findAllclass(search1,paging);
    }

    @GetMapping(value = "/allclass1")
    public List<Classes> getclassall(){
        return classesRepository.findAll();
    }
}
