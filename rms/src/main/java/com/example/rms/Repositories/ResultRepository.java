package com.example.rms.Repositories;

import com.example.rms.Entity.Results;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public interface ResultRepository extends JpaRepository<Results, Integer> {
    @Query(value = "select * from  results where evaluation_id = ?1", nativeQuery = true)
    List<Results> findlistresultbyIDevaluation(Integer id);

    @Query(value = "select * from  results where result_id = ?1", nativeQuery = true)
    Results findbyid(Integer id);

    @Modifying
    @Query(value = "DELETE FROM results WHERE evaluation_id = ?1", nativeQuery = true)
    void deletebyevaluation(Integer idevaluation);
}
