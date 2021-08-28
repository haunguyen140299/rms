package com.example.rms.Repositories;


import com.example.rms.Entity.Achievements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public interface AchivevementsRepository extends JpaRepository<Achievements, Integer> {
    @Query(value = "select * from  Achievements ac where  ac.profile_id=?1", nativeQuery = true)
    List<Achievements> findAllByIdProfile(Integer id);
    @Modifying
    @Query(value = "INSERT INTO Achievements ( image ,name_achi, time_achi,profile_id, achievements_id ) " +
            "value (?1, ?2, ?3, ?4,?5) ", nativeQuery = true)
    void createAchivement(String image, String name_achi, Date time_achi, Integer profile_id, Integer achievements_id);
}
