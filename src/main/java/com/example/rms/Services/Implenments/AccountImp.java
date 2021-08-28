package com.example.rms.Services.Implenments;


import com.example.rms.Entity.Account;
import com.example.rms.Repositories.AccountRepository;
import com.example.rms.Services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AccountImp implements AccountService {
    @Autowired
    AccountRepository accountRepository;
    private AccountImp(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }
    @Override
    public List<Account> findAll() {
        return this.accountRepository.findAll();
    }

    @Override
    public Optional<Account> findAllbyID(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(Account account){
        this.accountRepository.save(account);
    }

    @Override
    public void remove(Account account) {

    }

    @Override
    public void deletebyid(Integer id) {
        this.accountRepository.deleteById(id);
    }

    @Override
    public List<Account> findAllByProfile_id(Integer id) {
        return null;
    }

    @Override
    public Optional<Account> findByID(Integer id) {
        return this.accountRepository.findById(id);
    }

    @Override
    public Account findaccountbyemail(String email) {
        return accountRepository.findAccountByusernme(email);
    }

    @Override
    public List<Account> findAllaccountbyIDevaluation(Integer id) {
        return accountRepository.findAllaccountbyIDevaluation(id);
    }

    @Override
    public List<Account> findAllassessorbyIDevaluation(Integer id) {
        return accountRepository.findAllassessorbyIDevaluation(id);
    }

    @Override
    public List<Account> findAllnotstudent() {
        return this.accountRepository.findAllnotstudent();
    }

    @Override
    public Object getaccnamebyid(Integer id) {
        return accountRepository.getaccnamebyid(id);
    }

    @Override
    public Integer countclassbyid(Integer id) {
        return accountRepository.countclassbyid(id);
    }

    @Override
    public Object getnameclassofaccount(Integer id) {
        return accountRepository.getnameclassofaccount(id);
    }

//    @Override
//    public Page<Account> findAllByNamePaging(Pageable pageable, String name) {
//        return null;
//    }


}
