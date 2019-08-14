package com.company.SaraMoujahedU1Capstone.model;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class SalesTax {

    @NotEmpty(message = "You must provide a state")
    @Size(min = 2, max = 2, message = "State must be 2 characters in length")
    private String state;
    @NotEmpty(message = "You must provide a rate")
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "99:9.99", inclusive = true)
    private BigDecimal rate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SalesTax)) return false;
        SalesTax salesTax = (SalesTax) o;
        return getState().equals(salesTax.getState()) &&
                getRate().equals(salesTax.getRate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getState(), getRate());
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}
