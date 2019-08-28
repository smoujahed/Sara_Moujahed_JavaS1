package com.trilogyed.clientservice.service;

import com.trilogyed.clientservice.model.ResponseViewModel;
import com.trilogyed.clientservice.model.Transaction;
import com.trilogyed.clientservice.model.TransactionViewModel;
import com.trilogyed.clientservice.util.feign.BankingFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceLayer {
    @Autowired
    BankingFeignClient feignClient;

    public ServiceLayer(BankingFeignClient feignClient) {
        this.feignClient = feignClient;
    }

    public ResponseViewModel getBalance(String number){
        Transaction transaction = feignClient.getAccountInfo(number);

        ResponseViewModel responseViewModel = new ResponseViewModel();
        responseViewModel.setNumber(transaction.getNumber());
        responseViewModel.setBalance(transaction.getCredit());
        return responseViewModel;
    }

    public ResponseViewModel creditAccount(TransactionViewModel transactionViewModel){
        Transaction transaction = new Transaction();
        transaction.setNumber(transactionViewModel.getNumber());
        transaction.setCredit(transactionViewModel.getCredit());

        Transaction fromService = feignClient.creditAccount(transaction);

        ResponseViewModel responseViewModel = new ResponseViewModel();
        responseViewModel.setNumber(fromService.getNumber());
        responseViewModel.setBalance(fromService.getCredit());
        return responseViewModel;
    }
}
