package com.example.rms.Repositories;

import com.example.rms.Entity.Classes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ClassesRepository extends JpaRepository<Classes,Integer> {
    @Query(value = "SELECT classes.class_id, classes.class_name, course.course_name as course from classes, course where classes.course_id = course.course_id and classes.class_name like ?1", nativeQuery = true)
    Page<Object> findAllclass(String search, Pageable pageable);
}
