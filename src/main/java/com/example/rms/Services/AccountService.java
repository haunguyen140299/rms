package com.example.rms.Services;

import com.example.rms.Entity.Account;
import com.example.rms.Entity.Achievements;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    List<Account> findAll();

    Optional<Account> findAllbyID(Integer id);

    void save(Account account);

    void remove(Account account);

    void deletebyid( Integer id);

    List<Account> findAllByProfile_id(Integer id);

    Optional<Account> findByID(Integer id);

    List<Account> findAllaccountbyIDevaluation(Integer id);

    List<Account> findAllassessorbyIDevaluation(Integer id);

    List<Account> findAllnotstudent();
    Account findaccountbyemail(String email);


    Object getaccnamebyid(Integer id);

    Integer countclassbyid(Integer id);

    Object getnameclassofaccount(Integer id);
}
