package com.trilogyed.bankingservice.controller;

import com.trilogyed.bankingservice.model.Transaction;
import com.trilogyed.bankingservice.repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class TransactionController {
    @Autowired
    TransactionRepo transactionRepo;
    @PostMapping("/addfunds")
    public Transaction creditAccount(@RequestBody Transaction transaction) {
        System.out.println("hello");
        System.out.println(transaction.toString());
        // get the current balance
        Transaction fromService = transactionRepo.findByNumber(transaction.getNumber());
        // add the current amount to the
        fromService.setCredit(fromService.getCredit() + transaction.getCredit());

        // send back to db
        transactionRepo.save(fromService);

        return fromService;
    }
    @GetMapping("/{number}")
    public Transaction getAccountInfo(@PathVariable("number") String number) {
        return transactionRepo.findByNumber(number);
    }
}
