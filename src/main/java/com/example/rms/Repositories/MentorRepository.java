package com.example.rms.Repositories;

import com.example.rms.Entity.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface MentorRepository extends JpaRepository<Mentor, Integer> {
}
