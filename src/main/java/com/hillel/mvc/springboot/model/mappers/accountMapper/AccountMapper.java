package com.hillel.mvc.springboot.model.mappers.accountMapper;

import com.hillel.mvc.springboot.model.Account;
import com.hillel.mvc.springboot.model.requests.AccountRequest;

public interface AccountMapper {
    Account getAccount(AccountRequest request);
}
