package com.javaguides.app.controller;

import com.javaguides.app.dto.AccountDto;
import com.javaguides.app.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;


    @PostMapping
    public ResponseEntity<AccountDto> saveAccount (@RequestBody AccountDto accountDto){

        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById (@PathVariable("id") Long id){

        return new ResponseEntity<>(accountService.getAccountById(id), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts (){
        List<AccountDto> allAccounts = accountService.getAllAccounts();
        return new ResponseEntity<>(allAccounts, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccountById (@PathVariable("id") Long id){

        accountService.deleteAccountById(id);

        return new ResponseEntity<>("Account Deleted Successfully", HttpStatus.OK);

    }


}
