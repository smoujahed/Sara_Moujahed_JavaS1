package com.company.SaraMoujahedU1M5Summative.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Book {
    private int bookID;
    @NotEmpty(message = "You must provide book ISBN")
    @Size(max = 15)
    private String isbn;
    @NotEmpty(message = "You must provide publish date")
    private String publishDate;
    @NotEmpty(message = "You must provide author ID")
    private int authorID;
    @NotEmpty(message = "You must provide title")
    @Size(max = 70)
    private String title;
    @NotEmpty(message = "You must provide publisher ID")
    private int publisherID;
    @NotEmpty(message = "You must provide book price")
    private double price;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book that = (Book) o;
        return getBookID() == that.getBookID() &&
                getIsbn().equals(that.getIsbn()) &&
                getPublishDate().equals(that.getPublishDate()) &&
                getAuthorID() == that.getAuthorID() &&
                getTitle().equals(that.getTitle()) &&
                getPublisherID() == that.getPublisherID() &&
                getPrice() == that.getPrice();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookID(), getIsbn(), getPublishDate(), getAuthorID(), getTitle(), getPublisherID(), getPrice());
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublisherID() {
        return publisherID;
    }

    public void setPublisherID(int publisherID) {
        this.publisherID = publisherID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
