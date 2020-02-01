package com.hillel.mvc.springboot.model.mappers.accountMapper;

import com.hillel.mvc.springboot.dao.userRepository.UserRepository;
import com.hillel.mvc.springboot.model.Account;
import com.hillel.mvc.springboot.model.User;
import com.hillel.mvc.springboot.model.requests.AccountRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class AccountMapperImpl implements AccountMapper {
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Autowired
    UserRepository userRepository;

    @Override
    public Account getAccount(AccountRequest request) {
        LocalDate creationDate = LocalDate.parse(request.getCreationDate(), dateTimeFormatter);
        User user = userRepository.getUserById(request.getUserId());
        System.out.println("++++++++++"+user);
        if (user == null) {
            return null;
        }
        return new Account(request.getId(), request.getAmount(), user, creationDate);
    }

    @Override
    public AccountRequest getAccountRequest(Account account) {
        return new AccountRequest(account.getId(),
                account.getAmount(),
                account.getCreationDate().toString(),
                account.getUser().getId());
    }
}
