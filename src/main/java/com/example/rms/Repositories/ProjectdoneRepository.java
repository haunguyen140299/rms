package com.example.rms.Repositories;


import com.example.rms.Entity.ProjectDone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public interface ProjectdoneRepository extends JpaRepository<ProjectDone, Integer> {
    @Query(value = "select * from  projectdone st where  profile_id = ?1",nativeQuery = true)
    List<ProjectDone> findAllByIdProfile(Integer id);
    @Modifying
    @Query(value = "INSERT INTO Projectdone (decription, name_project,technical, time_project , teamsize, profile_id, project_done_id) " +
            "value (?1, ?2, ?3, ?4,?5,?6,?7) ", nativeQuery = true)
    void createProjectdone(String decription, String name_project, String techincal, Date time_project, Integer teamsize, Integer profile_id, Integer project_done_id);

}