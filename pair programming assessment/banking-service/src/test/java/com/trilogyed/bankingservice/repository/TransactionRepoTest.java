package com.trilogyed.bankingservice.repository;

import com.trilogyed.bankingservice.model.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Table;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionRepoTest {

    @Autowired
    TransactionRepo repo;

    @Before
    public void setUp() throws Exception {
        repo.deleteAll();
    }

    @Test
    public void addGetDeleteTransaction(){
        Transaction transaction = new Transaction();
        transaction.setNumber("100");
        transaction.setCredit(1000);

        transaction = repo.save(transaction);
        assertEquals(transaction, repo.findById(transaction.getTransactionId()).get());

        repo.deleteById(transaction.getTransactionId());
        assertEquals(Optional.empty(), repo.findById(transaction.getTransactionId()));
    }

    @Test
    public void findAllTransactions(){
        assertEquals(repo.findAll().size(), 0);
        Transaction transaction = new Transaction();
        transaction.setNumber("100");
        transaction.setCredit(1000);

        transaction = repo.save(transaction);
        assertEquals(repo.findAll().size(), 1);
        assertEquals(repo.findAll().get(0), transaction);
    }

    @Test
    public void updateTransaction(){
        Transaction transaction = new Transaction();
        transaction.setNumber("100");
        transaction.setCredit(1000);

        transaction = repo.save(transaction);
        transaction.setNumber("101");
        repo.save(transaction);
        assertEquals(transaction, repo.findById(transaction.getTransactionId()).get());

    }



}