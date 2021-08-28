package com.example.rms.Services;

import com.example.rms.DTO.ProjectdoneDTO;
import com.example.rms.Entity.ProjectDone;

import java.util.List;
import java.util.Optional;

public interface ProjectdoneService {
    void save(ProjectDone projectDone);

    void remove(ProjectDone projectDone);

    void deletebyid( Integer id);
    void createProjectdone(ProjectdoneDTO projectdoneDTO);
    List<ProjectDone> findAllByProfile_id(Integer id);
    Optional<ProjectDone> findAllbyID(Integer id);
}
