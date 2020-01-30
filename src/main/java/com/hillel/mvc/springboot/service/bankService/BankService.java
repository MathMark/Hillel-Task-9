package com.hillel.mvc.springboot.service.bankService;

import com.hillel.mvc.springboot.model.Account;
import com.hillel.mvc.springboot.model.Transaction;

import java.util.List;

public interface BankService {
    float withdraw(Account account, float amount) throws Exception;

    float topUp(Account account, float amount);

    boolean transfer(Account sender, Account receiver, float amount);

    default float getAmount(Account account) {
        return account.getAmount();
    }

    List<Transaction> getTransactions(Account account);
}
