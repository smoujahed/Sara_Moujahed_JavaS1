package com.trilogyed.clientservice.model;

import java.util.Objects;

public class TransactionViewModel {

    private String number;
    private int credit;

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
        if (!(o instanceof TransactionViewModel)) return false;
        TransactionViewModel that = (TransactionViewModel) o;
        return getCredit() == that.getCredit() &&
                getNumber().equals(that.getNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber(), getCredit());
    }
}
