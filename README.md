# bank-application

In this version, the lambda expression account -> AccountMapper.mapToAccountDto(account) is used to convert each Account object to an AccountDto object. This achieves the same result as using the method reference but is written explicitly as a lambda expressi

@Override
public List<AccountDto> getAllAccounts() {
List<Account> accountList = accountRepository.findAll();
return accountList.stream()
.map(account -> AccountMapper.mapToAccountDto(account))
.collect(Collectors.toList());
}



In this version:

The method does not take any parameters since it seems unnecessary.
The map method uses a method reference AccountMapper::mapToAccountDto to convert each Account object to an AccountDto object.


@Override
public List<AccountDto> getAllAccounts() {
List<Account> accountList = accountRepository.findAll();
return accountList.stream()
.map(AccountMapper::mapToAccountDto)
.collect(Collectors.toList());
}
