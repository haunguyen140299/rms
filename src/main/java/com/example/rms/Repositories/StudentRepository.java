package com.example.rms.Repositories;

import com.example.rms.Entity.Achievements;
import com.example.rms.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query(value = "Select * from student where evaluation_id = ?1", nativeQuery = true)
    List<Student> findAllbyidevaluation(Integer id);

    @Query(value = "Select avg(score) from results where student_id = ?1 and evaluation_id = ?2", nativeQuery = true)
    Float avgstudent(Integer id, Integer idevaluation);

    @Modifying
    @Query(value = "DELETE FROM results WHERE student_id = ?1 and evaluation_id = ?2", nativeQuery = true)
    void deleteresult(Integer idassessor,Integer idevaluation);
    @Modifying
    @Query(value = "DELETE FROM student WHERE student_id = ?1 and evaluation_id = ?2", nativeQuery = true)
    void deletebyidstudent(Integer idstudent,Integer idevaluation);
}
