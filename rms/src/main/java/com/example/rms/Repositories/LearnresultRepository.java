package com.example.rms.Repositories;


import com.example.rms.Entity.Learnresult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface LearnresultRepository extends JpaRepository<Learnresult, Integer> {
    @Query(value = "select * from  learnresult st where  st.profile_id = ?1",nativeQuery = true)
    List<Learnresult> findAllByIdprofile(Integer id);
    @Modifying
    @Query(value = "Insert into learnresult(name_learn, result_learn,profile_id, learn_result_id ) value (?1,?2,?3,?4)", nativeQuery = true)
    void createLearnresult(String name_learn, String result_learn, Integer profile_id, Integer learn_result_id);
}
