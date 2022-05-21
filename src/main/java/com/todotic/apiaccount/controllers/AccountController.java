package com.todotic.apiaccount.controllers;

import com.todotic.apiaccount.documents.Account;
import com.todotic.apiaccount.services.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/")
public class AccountController {

    @Autowired
    IAccountService service;

    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.ACCEPTED);
    }

    @PostMapping("/accounts")
    public ResponseEntity<Account> create(@RequestBody Account account) {

        Account existAccount = service.findByPhoneNumber(account.getPhoneNumber());
        if (existAccount != null && Boolean.TRUE.equals(validarDNI(account.getIdentityDocumentNumber()))) {
            Account newAccount = service.create(account);
            return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(new Account(), HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/accounts", params = "phoneNumber")
    public ResponseEntity<Account> findByPhoneNumber(@RequestParam("phoneNumber") String phoneNumber) {
        Account findAccount = service.findByPhoneNumber(phoneNumber);
        if (findAccount != null) {
            return new ResponseEntity<>(findAccount, HttpStatus.OK);
        }
        return new ResponseEntity<>(new Account(), HttpStatus.NOT_FOUND);
    }

    public Boolean validarDNI(String dni) {
        String regex = "[0-9]{8}";
        return dni.matches(regex);
    }

}
