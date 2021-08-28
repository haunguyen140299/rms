package com.example.rms.Services.Implenments;

import com.example.rms.DTO.StudyprocessDTO;
import com.example.rms.Entity.StudyProcess;
import com.example.rms.Repositories.StudyprocessRepository;
import com.example.rms.Services.StudyprocesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudyprocessImp implements StudyprocesService {
    @Autowired
    private StudyprocessRepository studyprocess_repository;
    public StudyprocessImp(StudyprocessRepository studyprocess_repository){
        this.studyprocess_repository = studyprocess_repository;
    }

    @Override
    public void save(StudyProcess studyProcess) {
        studyprocess_repository.save(studyProcess);
    }

    @Override
    public void remove(StudyProcess studyProcess) {
        studyprocess_repository.delete(studyProcess);
    }

    @Override
    public void deletebyid(Integer id) {
        studyprocess_repository.deleteById(id);
    }

    @Override
    public void createStudyprocess(StudyprocessDTO studyprocessDTO) {
        studyprocess_repository.createStudyprocess(
                studyprocessDTO.getNote(),
                studyprocessDTO.getSchool(),
                studyprocessDTO.getTime_process(),
                studyprocessDTO.getProfile_id(),
                studyprocessDTO.getStudy_process_id()
        );
    }


    @Override
    public List<StudyProcess> findAllByProfile_id(Integer id) {

        return  this.studyprocess_repository.findAllByProfile_id(id);
    }

    @Override
    public Optional<StudyProcess> findAllbyID(Integer id) {
        return this.studyprocess_repository.findById(id);
    }

    @Override
    public void deleteBYID(Integer id) {
         this.studyprocess_repository.deleteById(id);
    }
}
