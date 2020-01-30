package com.hillel.mvc.springboot.service.bankService;

import com.hillel.mvc.springboot.model.Account;
import com.hillel.mvc.springboot.model.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractBankService implements BankService {
    List<Transaction> transactions = new ArrayList<>();

    @Override
    public abstract float withdraw(Account account, float amount) throws Exception;

    @Override
    public abstract float topUp(Account account, float amount);

    @Override
    public abstract boolean transfer(Account sender, Account receiver, float amount);

    @Override
    public List<Transaction> getTransactions(Account account) {
        return transactions.stream()
                .filter(t -> t.getReceiver().equals(account) || t.getSender().equals(account))
                .collect(Collectors.toList());
    }
}
