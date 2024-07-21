package com.javaguides.app.mapper;

import com.javaguides.app.dto.AccountDto;
import com.javaguides.app.entity.Account;
/*
 *
 *  1. Converting AccountDto to Account
 *  2. Converting Account to AccountDto
 *
 * */

public class AccountMapper {

    public static Account mapToAccount (AccountDto accountDto){

        Account account = new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance()
        );
        return account;

    }

    public static AccountDto mapToAccountDto (Account account){

        AccountDto accountDto = new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
        return accountDto;

    }
}
