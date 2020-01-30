package com.hillel.mvc.springboot.service.transactionExplorer;


import com.hillel.mvc.springboot.model.Account;
import com.hillel.mvc.springboot.model.Transaction;

@FunctionalInterface
public interface TransactionExplorer {
    void displayTransaction(Account account, Transaction transaction);
}
