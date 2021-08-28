package com.example.rms.Repositories;

import com.example.rms.Entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface LessonRepository extends JpaRepository<Lesson, Integer> {
}
