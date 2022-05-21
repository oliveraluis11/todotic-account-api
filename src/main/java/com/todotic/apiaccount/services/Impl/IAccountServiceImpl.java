package com.todotic.apiaccount.services.Impl;

import com.todotic.apiaccount.documents.Account;
import com.todotic.apiaccount.repositories.AccountRepository;
import com.todotic.apiaccount.services.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IAccountServiceImpl implements IAccountService {

    @Autowired
    AccountRepository repository;

    @Override
    public Account findByPhoneNumber(String phoneNumber) {
        return repository.findByPhoneNumber(phoneNumber);
    }

    @Override
    public List<Account> findAll() {
        return repository.findAll();
    }

    @Override
    public Account create(Account o) {
        return repository.save(o);
    }
}
