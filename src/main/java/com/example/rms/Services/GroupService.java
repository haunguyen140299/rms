package com.example.rms.Services;

import com.example.rms.Entity.Classes;
import com.example.rms.Entity.Group;

import java.util.List;
import java.util.Optional;

public interface GroupService {
    List<Group> findAll();

    Optional<Group> findAllbyID(Integer id);

    void save(Group group);

    void remove(Group group);

    void deletebyid( Integer id);
}
