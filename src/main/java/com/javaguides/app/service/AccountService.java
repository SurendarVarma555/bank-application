package com.javaguides.app.service;

import com.javaguides.app.dto.AccountDto;

import java.util.List;

public interface AccountService {

    public AccountDto createAccount (AccountDto accountDto);

    AccountDto getAccountById (Long id);

    List<AccountDto> getAllAccounts ();

    void deleteAccountById (Long id);
}
