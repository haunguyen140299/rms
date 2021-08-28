package com.example.rms.Repositories;

import com.example.rms.Entity.ERole;
import com.example.rms.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Repository
@Transactional
public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role findByName(ERole name);
}
