package com.trilogyed.clientservice.model;

import java.util.Objects;

public class ResponseViewModel {
    private String number;
    private int balance;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResponseViewModel)) return false;
        ResponseViewModel that = (ResponseViewModel) o;
        return getBalance() == that.getBalance() &&
                getNumber().equals(that.getNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber(), getBalance());
    }
}
