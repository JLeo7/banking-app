package com.immersive.bankingapp.resource;

import com.immersive.bankingapp.model.Account;
import com.immersive.bankingapp.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/account")
public class AccountResource {
    private AccountService accountService;

    public AccountResource(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<Account> save(@RequestBody Account account) {
        Account savedAccount = this.accountService.save(account);
        return new ResponseEntity<>(savedAccount, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List> findAllByUserId(@PathVariable int userId) {
        List<Account> accounts = this.accountService.findAllAccountsByUserId(userId);
        return new ResponseEntity<>(accounts,HttpStatus.OK);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<Account> findByAccountId(@PathVariable int accountId) {
        Account account = this.accountService.findByAccountId(accountId);
        return new ResponseEntity<>(account,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Account> findByNumber(@RequestParam(value = "number") int number) {
        Account account = this.accountService.findByAccountNumber(number);
        return new ResponseEntity<>(account,HttpStatus.OK);
    }

}
