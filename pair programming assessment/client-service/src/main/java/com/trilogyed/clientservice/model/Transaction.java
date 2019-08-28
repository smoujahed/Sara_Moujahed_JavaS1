package com.trilogyed.clientservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Objects;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Transaction {

    private Integer transactionId;
    private String number;
    private int credit;

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction)) return false;
        Transaction that = (Transaction) o;
        return getCredit() == that.getCredit() &&
                getTransactionId().equals(that.getTransactionId()) &&
                getNumber().equals(that.getNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTransactionId(), getNumber(), getCredit());
    }
}
