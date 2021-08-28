package com.example.rms.Services;

import com.example.rms.DTO.StudyprocessDTO;
import com.example.rms.Entity.StudyProcess;

import java.util.List;
import java.util.Optional;

public interface StudyprocesService {
    void save(StudyProcess studyProcess);

    void remove(StudyProcess studyProcess);

    void deletebyid( Integer id);
    void createStudyprocess(StudyprocessDTO studyprocessDTO);

    List<StudyProcess> findAllByProfile_id(Integer id);
    Optional<StudyProcess> findAllbyID(Integer id);
    void deleteBYID(Integer id);
}
