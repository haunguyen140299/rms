package com.example.rms.Services.Implenments;

import com.example.rms.Entity.Group;
import com.example.rms.Repositories.GroupRepository;
import com.example.rms.Services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class GroupImp implements GroupService {
    @Autowired
    private  GroupRepository groupRepository;
    private  GroupImp(GroupRepository groupRepository){
        this.groupRepository = groupRepository;
    }
    @Override
    public List<Group> findAll() {
        return this.groupRepository.findAll();
    }

    @Override
    public Optional<Group> findAllbyID(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(Group group) {

    }

    @Override
    public void remove(Group group) {

    }

    @Override
    public void deletebyid(Integer id) {

    }
}
