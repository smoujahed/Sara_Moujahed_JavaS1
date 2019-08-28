package com.trilogyed.clientservice.service;

import com.trilogyed.clientservice.model.ResponseViewModel;
import com.trilogyed.clientservice.model.Transaction;
import com.trilogyed.clientservice.model.TransactionViewModel;
import com.trilogyed.clientservice.util.feign.BankingFeignClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class ServiceLayerTest {

    @Mock
    BankingFeignClient feignClient;

    @Mock
    ServiceLayer serviceLayer;

    @Before
    public void setUp() throws Exception {
        setUpBankClient();
        serviceLayer = new ServiceLayer(feignClient);
    }


    public void setUpBankClient(){
        Transaction transaction = new Transaction();
        transaction.setTransactionId(1);
        transaction.setNumber("100");
        transaction.setCredit(1000);

        Transaction transaction1 = new Transaction();
        transaction1.setTransactionId(1);
        transaction1.setNumber("100");
        transaction1.setCredit(3000);

        doReturn(transaction1).when(feignClient).creditAccount(transaction);
        doReturn(transaction).when(feignClient).getAccountInfo("100");
    }

    @Test
    public void getBalance(){
        ResponseViewModel responseViewModel = new ResponseViewModel();
        responseViewModel.setNumber("100");
        responseViewModel.setBalance(1000);
        assertEquals(responseViewModel, serviceLayer.getBalance("100"));
    }
    @Test
    public void creditAccount(){
//        Transaction transaction1 = new Transaction();
//        transaction1.setTransactionId(1);
//        transaction1.setNumber("100");
//        transaction1.setCredit(3000);

        ResponseViewModel responseViewModel = new ResponseViewModel();
        responseViewModel.setNumber("100");
        responseViewModel.setBalance(3000);

        TransactionViewModel transactionViewModel = new TransactionViewModel();
        transactionViewModel.setNumber("100");
        transactionViewModel.setCredit(3000);

        assertEquals(responseViewModel, serviceLayer.creditAccount(transactionViewModel));
    }
}