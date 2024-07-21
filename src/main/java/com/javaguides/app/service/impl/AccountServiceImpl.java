package com.javaguides.app.service.impl;

import com.javaguides.app.dto.AccountDto;
import com.javaguides.app.entity.Account;
import com.javaguides.app.mapper.AccountMapper;
import com.javaguides.app.repository.AccountRepository;
import com.javaguides.app.service.AccountService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountDto createAccount (AccountDto accountDto){
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById (Long id){
        Account foundAccount = accountRepository.findById(id).get();
        return AccountMapper.mapToAccountDto(foundAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts (){
        List<Account> accountList = accountRepository.findAll();
        return accountList.stream()
                .map(account -> AccountMapper.mapToAccountDto(account))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAccountById (Long id){
        Optional<Account> accountOptional = accountRepository.findById(id);
        if (accountOptional.isPresent()) {
            accountRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Account with id " + id + " not found");
        }
    }


}

