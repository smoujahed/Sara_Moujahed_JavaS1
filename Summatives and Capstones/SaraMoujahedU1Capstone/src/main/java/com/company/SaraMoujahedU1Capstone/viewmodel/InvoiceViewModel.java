package com.company.SaraMoujahedU1Capstone.viewmodel;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class InvoiceViewModel {

    private int invoiceId;
    @NotEmpty(message = "You must provide a name")
    @Size(max = 80, message = "Character max for name is 80")
    private String name;
    @NotEmpty(message = "You must provide a street")
    @Size(max = 30, message = "Character max for street is 30")
    private String street;
    @NotEmpty(message = "You must provide a city")
    @Size(max = 30, message = "Character max for city is 30")
    private String city;
    @NotEmpty(message = "You must provide a state")
    @Size(max = 2, message = "Character max for state is 2")
    private String state;
    @NotEmpty(message = "You must provide a zipcode")
    @Size(min = 5, max = 5, message = "Zipcode must be 5 characters")
    private String zipcode;
    @NotEmpty(message = "You must provide an item type")
    @Size(max = 20, message = "Character max for item type is 20")
    private String itemType;
    @NotEmpty(message = "You must provide an item ID")
    @Size(max = 11, message = "Character max for item ID is 11")
    private int itemId;
    @NotEmpty(message = "You must provide a quantity")
    @Size(max = 11, message = "Character max for quantity is 11")
    private int quantity;

    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "99999.99", inclusive = true)
    private BigDecimal unitPrice;
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "99999.99", inclusive = true)
    private BigDecimal subtotal;
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "99999.99", inclusive = true)
    private BigDecimal tax;
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "99999.99", inclusive = true)
    private BigDecimal processingFee;
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "99999.99", inclusive = true)
    private BigDecimal total;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvoiceViewModel)) return false;
        InvoiceViewModel that = (InvoiceViewModel) o;
        return getInvoiceId() == that.getInvoiceId() &&
                getItemId() == that.getItemId() &&
                getQuantity() == that.getQuantity() &&
                getName().equals(that.getName()) &&
                getStreet().equals(that.getStreet()) &&
                getCity().equals(that.getCity()) &&
                getState().equals(that.getState()) &&
                getZipcode().equals(that.getZipcode()) &&
                getItemType().equals(that.getItemType()) &&
                getUnitPrice().equals(that.getUnitPrice()) &&
                getSubtotal().equals(that.getSubtotal()) &&
                getTax().equals(that.getTax()) &&
                getProcessingFee().equals(that.getProcessingFee()) &&
                getTotal().equals(that.getTotal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInvoiceId(), getName(), getStreet(), getCity(), getState(), getZipcode(), getItemType(), getItemId(), getQuantity(), getUnitPrice(), getSubtotal(), getTax(), getProcessingFee(), getTotal());
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(BigDecimal processingFee) {
        this.processingFee = processingFee;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
