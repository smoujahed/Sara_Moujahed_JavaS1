package com.trilogyed.bankingservice.repository;

import com.trilogyed.bankingservice.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Integer> {
    Transaction findByNumber(String number);
}
