package com.company.SaraMoujahedU1Capstone.viewmodel;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class ConsoleViewModel {

    @Size(max = 11)
    private int consoleId;
    @NotEmpty(message = "You must provide a model")
    @Size(max = 50, message = "Character max for model is 50")
    private String model;
    @NotEmpty(message = "You must provide a manufacturer")
    @Size(max = 50, message = "Character max for manufacturer is 50")
    private String manufacturer;
    @Size(max = 20, message = "Character max for memory amount is 20")
    private String memoryAmount;
    @Size(max = 20, message = "Character max for processor")
    private String processor;
    @NotEmpty(message = "You must provide a price")
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "99999.99", inclusive = true)
    private BigDecimal price;
    @NotEmpty(message = "You must provide a quantity")
    private int quantity;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConsoleViewModel)) return false;
        ConsoleViewModel that = (ConsoleViewModel) o;
        return getConsoleId() == that.getConsoleId() &&
                getModel().equals(that.getModel()) &&
                getManufacturer().equals(that.getManufacturer()) &&
                getMemoryAmount().equals(that.getMemoryAmount()) &&
                getProcessor().equals(that.getProcessor()) &&
                getPrice().equals(that.getPrice()) &&
                getQuantity() == that.getQuantity();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getConsoleId(), getModel(), getManufacturer(), getMemoryAmount(), getProcessor(), getPrice(), getQuantity());
    }

    public int getConsoleId() {
        return consoleId;
    }

    public void setConsoleId(int consoleId) {
        this.consoleId = consoleId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMemoryAmount() {
        return memoryAmount;
    }

    public void setMemoryAmount(String memoryAmount) {
        this.memoryAmount = memoryAmount;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
