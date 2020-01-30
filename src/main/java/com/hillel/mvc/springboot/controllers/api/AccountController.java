package com.hillel.mvc.springboot.controllers.api;

import com.hillel.mvc.springboot.dao.accountRepository.AccountRepository;
import com.hillel.mvc.springboot.model.Account;
import com.hillel.mvc.springboot.model.requests.AccountRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/accounts")
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Account>> getAccounts(){
        return new ResponseEntity<>(accountRepository.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{accountId}", method = RequestMethod.GET)
    public ResponseEntity<Account> getAccountById(@PathVariable("accountId") String accountId) {
        Account account = accountRepository.getById(Integer.parseInt(accountId));
        if(account == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createAccount(@RequestBody AccountRequest request){
        boolean successfully = accountRepository.save(request);
        return new ResponseEntity((successfully) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/{accountId}", method = RequestMethod.PUT)
    public ResponseEntity updateAccount(@PathVariable("accountId") String accountId, @RequestBody AccountRequest request){
        boolean successfully = accountRepository.update(Integer.parseInt(accountId), request);
        return new ResponseEntity((successfully) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/{accountId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteAccount(@PathVariable("accountId") String accountId){
        boolean successfully = accountRepository.delete(Integer.parseInt(accountId));
        return new ResponseEntity((successfully) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

}
