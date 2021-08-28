package com.example.rms.Services.Implenments;

import com.example.rms.DTO.ProjectdoneDTO;
import com.example.rms.Entity.ProjectDone;
import com.example.rms.Repositories.ProjectdoneRepository;
import com.example.rms.Services.ProjectdoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProjectdoneImp implements ProjectdoneService {
    @Autowired
    private ProjectdoneRepository projectdone_repository;
    @Override
    public void save(ProjectDone projectDone) {
        this.projectdone_repository.save(projectDone);
    }

    @Override
    public void remove(ProjectDone projectDone) {
        this.projectdone_repository.delete(projectDone);
    }

    @Override
    public void deletebyid(Integer id) {
        this.projectdone_repository.deleteById(id);
    }

    @Override
    public void createProjectdone(ProjectdoneDTO projectdoneDTO) {
        projectdone_repository.createProjectdone(
                projectdoneDTO.getDecription(),
                projectdoneDTO.getName_project(),
                projectdoneDTO.getTechnical(),
                projectdoneDTO.getTime_project(),
                projectdoneDTO.getTeamsize(),
                projectdoneDTO.getProfile_id(),
                projectdoneDTO.getProject_done_id()
        );
    }

    @Override
    public List<ProjectDone> findAllByProfile_id(Integer id) {
        return  projectdone_repository.findAllByIdProfile(id);
    }

    @Override
    public Optional<ProjectDone> findAllbyID(Integer id) {
        return projectdone_repository.findById(id);
    }
}
