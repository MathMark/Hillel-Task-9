package com.hillel.mvc.springboot.dao.accountRepository;

import com.hillel.mvc.springboot.model.Account;
import com.hillel.mvc.springboot.model.User;
import com.hillel.mvc.springboot.model.mappers.accountMapper.AccountMapper;
import com.hillel.mvc.springboot.model.requests.AccountRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@Component
public class AccountRepositoryImpl implements AccountRepository {

    private Map<Integer, Account> accountMap = new ConcurrentHashMap<>();
    private Map<User, Account> userAccountMap = new ConcurrentHashMap<>();
    private int accountId;

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public List<Account> getAll() {
        return new ArrayList<>(accountMap.values());
    }

    @Override
    public Account getById(int id) {
        return accountMap.get(id);
    }

    @Override
    public boolean save(AccountRequest accountRequest) {
        Account account = accountMapper.getAccount(accountRequest);
        if(account.getUser() == null){
            return false;
        }
        return save(account);
    }

    @Override
    public boolean save(Account account) {
        account.setId(accountId);
        accountMap.put(accountId, account);
        userAccountMap.put(account.getUser(), account);
        accountId++;
        return true;
    }

    @Override
    public boolean update(int id, AccountRequest accountRequest) {
        Account updatedAccount = accountMapper.getAccount(accountRequest);
        return update(id, updatedAccount);
    }

    @Override
    public boolean update(int id, Account account) {
        if((account.getUser() == null) || (!accountMap.containsKey(id))){
            return false;
        }
        accountMap.put(id, account);
        userAccountMap.put(account.getUser(), account);
        return true;
    }

    @Override
    public boolean delete(int id) {
        Account oldAccount = accountMap.get(id);
        if(oldAccount == null){
            return false;
        }
        accountMap.remove(id);
        userAccountMap.remove(oldAccount.getUser());
        return true;
    }

    @Override
    public Map<User, Account> getMap() {
        return userAccountMap;
    }
}
