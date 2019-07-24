package com.company.SaraMoujahedU1Capstone.viewmodel;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class TShirtViewModel {
    @Size(max = 11, message = "Character max for t-shirt ID is 11")
    private int tShirtId;
    @NotEmpty(message = "You must provide a size")
    @Size(max = 20, message = "Character max for size is 20")
    private String size;
    @NotEmpty(message = "You must provide a color")
    @Size(max = 20, message = "Character max for color is 20")
    private String color;
    @NotEmpty(message = "You must provide a description")
    @Size(max = 255, message = "Character max for description is 255")
    private String description;
    @NotEmpty(message = "You must provide a price")
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "999999.99", inclusive = true)
    private BigDecimal price;
    @NotEmpty(message = "You must provide a quantity")
    @Size(max = 11, message = "Character max for quantity is 11")
    private int quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TShirtViewModel)) return false;
        TShirtViewModel that = (TShirtViewModel) o;
        return gettShirtId() == that.gettShirtId() &&
                getQuantity() == that.getQuantity() &&
                getSize().equals(that.getSize()) &&
                getColor().equals(that.getColor()) &&
                getDescription().equals(that.getDescription()) &&
                getPrice().equals(that.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(gettShirtId(), getSize(), getColor(), getDescription(), getPrice(), getQuantity());
    }

    public int gettShirtId() {
        return tShirtId;
    }

    public void settShirtId(int tShirtId) {
        this.tShirtId = tShirtId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
