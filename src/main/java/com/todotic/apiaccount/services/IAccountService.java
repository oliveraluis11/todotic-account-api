package com.todotic.apiaccount.services;

import com.todotic.apiaccount.documents.Account;

public interface IAccountService extends ICRUDService<Account, String>{
    public Account findByPhoneNumber(String phoneNumber);
}
