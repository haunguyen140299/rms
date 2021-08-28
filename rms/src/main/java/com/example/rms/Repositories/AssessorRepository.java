package com.example.rms.Repositories;

import com.example.rms.Entity.Assessor;
import com.example.rms.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public interface AssessorRepository extends JpaRepository<Assessor, Integer> {
    @Query(value = "Select * from assessor where evaluation_id = ?1", nativeQuery = true)
    List<Assessor> findAllbyidevaluation(Integer id);
    @Modifying
    @Query(value = "DELETE FROM results WHERE assessor_id = ?1 and evaluation_id = ?2", nativeQuery = true)
    void deleteresult(Integer idassessor,Integer idevaluation);
    @Modifying
    @Query(value = "DELETE FROM assessor WHERE assessor_id = ?1 and evaluation_id = ?2", nativeQuery = true)
    void deletebyidassessor(Integer idassessor,Integer idevaluation);
}
