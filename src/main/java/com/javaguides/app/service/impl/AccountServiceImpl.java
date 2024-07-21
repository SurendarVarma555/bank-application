package com.javaguides.app.service.impl;

import com.javaguides.app.dto.AccountDto;
import com.javaguides.app.repository.AccountRepository;
import com.javaguides.app.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountDto createAccount (AccountDto accountDto){
        return null;
    }
}
