package com.example.rms.Repositories;

import com.example.rms.Entity.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
//    Page<Profile> findAllByNameContaining(Pageable pageable, String name);
    Page<Profile> findAllByNameContainingOrderByCreateDateDesc(Pageable pageable, String name);

}
