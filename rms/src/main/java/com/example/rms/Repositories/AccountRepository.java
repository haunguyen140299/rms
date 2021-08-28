package com.example.rms.Repositories;
import com.example.rms.Entity.Account;
import com.example.rms.Entity.Achievements;
import io.swagger.models.auth.In;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface AccountRepository extends JpaRepository<Account, Integer> {

    Optional<Account>  findAccountByUsername(String username);
    Page<Account> findAllByFullnameContaining(Pageable pageable, String seach);
    Boolean existsAccountByUsername(String username);
    @Query(value = "select * from account where username = ?1 ", nativeQuery = true)
    Account findAccountByusernme(String username);
    @Query(value = "SELECT * FROM account WHERE pwdtoken=?1 ", nativeQuery = true)
    Account findByToken(String token);

    @Query(value = "SELECT * FROM student INNER JOIN account ON student.student_id = account.account_id WHERE evaluation_id = ?1", nativeQuery = true)
    List<Account> findAllaccountbyIDevaluation(Integer id);

    @Query(value = "SELECT * FROM assessor INNER JOIN account ON assessor.assessor_id = account.account_id WHERE evaluation_id = ?1", nativeQuery = true)
    List<Account> findAllassessorbyIDevaluation(Integer id);

    @Query(value = "SELECT * FROM account WHERE group_id != 1", nativeQuery = true)
    List<Account> findAllnotstudent();

    @Query(value = "SELECT fullname,account_id FROM account WHERE account_id = ?1", nativeQuery = true)
    Object getaccnamebyid(Integer id);

    @Query(value = "SELECT count(class_id) FROM account WHERE class_id = ?1", nativeQuery = true)
    Integer countclassbyid(Integer id);

    @Query(value = "SELECT class_id,class_name FROM classes WHERE class_id = ?1", nativeQuery = true)
    Object getnameclassofaccount(Integer id);
}


