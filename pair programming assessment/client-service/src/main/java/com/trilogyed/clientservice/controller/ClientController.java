package com.trilogyed.clientservice.controller;

import com.trilogyed.clientservice.model.ResponseViewModel;
import com.trilogyed.clientservice.model.Transaction;
import com.trilogyed.clientservice.model.TransactionViewModel;
import com.trilogyed.clientservice.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ServiceLayer serviceLayer;
    @GetMapping("/{number}")
    public ResponseViewModel getBalance(@PathVariable("number") String number) {
        return serviceLayer.getBalance(number);
    }
    @PostMapping("/credit")
    public ResponseViewModel getBalance(@RequestBody TransactionViewModel transactionViewModel) {
        return serviceLayer.creditAccount(transactionViewModel);
    }

}
