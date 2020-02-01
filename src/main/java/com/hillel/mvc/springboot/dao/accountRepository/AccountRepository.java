package com.hillel.mvc.springboot.dao.accountRepository;

import com.hillel.mvc.springboot.model.Account;
import com.hillel.mvc.springboot.model.User;
import com.hillel.mvc.springboot.model.requests.AccountRequest;

import java.util.List;
import java.util.Map;

public interface AccountRepository {
    List<Account> getAll();
    Account getById(int id);
    boolean save(Account account);
    boolean update(int id, Account account);
    boolean delete(int id);
}
