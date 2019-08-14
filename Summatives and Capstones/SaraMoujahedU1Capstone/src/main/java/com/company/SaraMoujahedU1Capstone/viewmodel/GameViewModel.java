package com.company.SaraMoujahedU1Capstone.viewmodel;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class GameViewModel {
    @Size(max = 11)
    private int gameId;
    @NotEmpty(message = "You must provide a title")
    @Size(max = 50, message = "Character max for title is 50")
    private String title;
    @NotEmpty(message = "You must provide an ESRB rating")
    @Size(max = 50, message = "Character max for ESRB rating is 50")
    private String esrbRating;
    @NotEmpty(message = "You must provide a description")
    @Size(max = 255, message = "Character max for description is 255")
    private String description;
    @NotEmpty(message = "You must provide a price")
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "99999.99", inclusive = true)
    private BigDecimal price;
    @NotEmpty(message = "you must provide a studio")
    @Size(max = 50, message = "Character max for studio rating is 50")
    private String studio;
    @Size(max = 11)
    private int quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameViewModel)) return false;
        GameViewModel that = (GameViewModel) o;
        return getGameId() == that.getGameId() &&
                getQuantity() == that.getQuantity() &&
                getTitle().equals(that.getTitle()) &&
                getEsrbRating().equals(that.getEsrbRating()) &&
                getDescription().equals(that.getDescription()) &&
                getPrice().equals(that.getPrice()) &&
                getStudio().equals(that.getStudio());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGameId(), getTitle(), getEsrbRating(), getDescription(), getPrice(), getStudio(), getQuantity());
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEsrbRating() {
        return esrbRating;
    }

    public void setEsrbRating(String esrbRating) {
        this.esrbRating = esrbRating;
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

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
