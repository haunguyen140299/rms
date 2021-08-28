package com.example.rms.Repositories;

import com.example.rms.Entity.Profile;
import com.example.rms.Entity.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    @Query(value = "SELECT subject.name_subject, subject.id_mentor, account.fullname as teacher, classes.class_name from subject, classes, account where classes.class_id = subject.class_id and subject.name_subject like ?1 and subject.id_teacher = account.account_id", nativeQuery = true)
    Page<Object> findAllevacritebyIDevaluation(String search,Pageable pageable);
}
