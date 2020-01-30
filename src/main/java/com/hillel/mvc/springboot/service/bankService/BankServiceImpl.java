package com.hillel.mvc.springboot.service.bankService;

import com.hillel.mvc.springboot.model.Account;
import com.hillel.mvc.springboot.model.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Slf4j
@Service(value = "bankService")
public class BankServiceImpl extends AbstractBankService {
    @Override
    public float withdraw(Account account, float amount) throws Exception {
        if (isValid(amount)) {
            float accountAmount = account.getAmount();
            if (accountAmount < amount) throw new Exception("There is not enough money on the current account");
            account.setAmount(accountAmount - amount);
            log.info("\n\n${} has been withdrawn from an account belonged to {} \nCurrent balance is: ${}",
                    amount,
                    account.getUser().getFirstName() + " " + account.getUser().getLastName(),
                    account.getAmount());
        }
        return account.getAmount();
    }

    @Override
    public float topUp(Account account, float amount) {
        if (isValid(amount)) {
            account.setAmount(account.getAmount() + amount);
            log.info("\n\n${} has been put to an account belonged to {} \nCurrent balance is: ${}",
                    amount,
                    account.getUser().getFirstName() + " " + account.getUser().getLastName(),
                    account.getAmount());
        }
        return account.getAmount();
    }

    @Override
    public boolean transfer(Account sender, Account receiver, float amount) {
        if ((!isValid(amount)) || (sender.getAmount() < amount)) return false;

        receiver.setAmount(receiver.getAmount() + amount);
        sender.setAmount(sender.getAmount() - amount);
        transactions.add(new Transaction(LocalDate.now(), sender, receiver, amount, true));
        log.info("\n\n{} → {} (${})", sender.getUser().getFirstName() + " " + sender.getUser().getLastName(),
                receiver.getUser().getFirstName() + " " + receiver.getUser().getLastName(),
                amount);
        return true;
    }

    private boolean isValid(float amount) {
        return amount > 0;
    }
}
