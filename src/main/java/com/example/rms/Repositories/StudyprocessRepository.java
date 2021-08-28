package com.example.rms.Repositories;

import com.example.rms.Entity.StudyProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public interface StudyprocessRepository extends JpaRepository<StudyProcess, Integer> {
    @Modifying
    @Query(value = "INSERT INTO Studyprocess (note, school ,time_process,profile_id, study_process_id) " +
            "value (?1, ?2, ?3, ?4,?5) ", nativeQuery = true)
    void createStudyprocess(String note, String school, Date time_process, Integer profile_id, Integer stuInteger);

    @Query(value = "select * from StudyProcess where  profile_id = ?1", nativeQuery = true)
    List<StudyProcess> findAllByProfile_id(Integer id);
}
