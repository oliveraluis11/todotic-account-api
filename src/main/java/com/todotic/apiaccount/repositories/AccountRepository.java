package com.todotic.apiaccount.repositories;

import com.todotic.apiaccount.documents.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {

    public Account findByPhoneNumber(String id);
}
