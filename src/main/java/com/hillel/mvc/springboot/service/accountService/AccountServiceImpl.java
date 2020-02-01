package com.hillel.mvc.springboot.service.accountService;

import com.hillel.mvc.springboot.dao.accountRepository.AccountRepository;
import com.hillel.mvc.springboot.model.Account;
import com.hillel.mvc.springboot.model.mappers.accountMapper.AccountMapper;
import com.hillel.mvc.springboot.model.requests.AccountRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.getAll();
    }

    @Override
    public AccountRequest getAccountRequestById(int id) {
        Account account = accountRepository.getById(id);
        return accountMapper.getAccountRequest(account);
    }

    @Override
    public Account getAccountById(int id) {
        return accountRepository.getById(id);
    }

    @Override
    public boolean save(AccountRequest accountRequest) {
        Account account = accountMapper.getAccount(accountRequest);
        return accountRepository.save(account);
    }

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }

    @Override
    public boolean update(AccountRequest accountRequest) {
        Account account = accountMapper.getAccount(accountRequest);
        return accountRepository.update(accountRequest.getId(), account);
    }

    @Override
    public void update(Account account) {
        accountRepository.save(account);
    }

    @Override
    public boolean delete(int accountId) {
        return accountRepository.delete(accountId);
    }
}
