package com.example.rms.Repositories;

import com.example.rms.Entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface GroupRepository extends JpaRepository<Group,Integer> {

}
