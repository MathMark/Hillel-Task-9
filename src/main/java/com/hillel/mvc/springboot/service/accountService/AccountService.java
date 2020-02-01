package com.hillel.mvc.springboot.service.accountService;

import com.hillel.mvc.springboot.model.Account;
import com.hillel.mvc.springboot.model.requests.AccountRequest;

import java.util.List;

public interface AccountService {

    List<Account> getAllAccounts();
    AccountRequest getAccountRequestById(int id);
    Account getAccountById(int id);
    boolean save(AccountRequest accountRequest);
    void save(Account account);
    boolean update(AccountRequest accountRequest);
    void update(Account account);
    boolean delete(int accountId);

}
