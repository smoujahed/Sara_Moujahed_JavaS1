package com.company.SaraMoujahedU1M5Summative.model;


import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Author {

    private int authorID;
    @NotEmpty(message = "You must provide a first name")
    @Size(max = 50)
    private String firstName;
    @NotEmpty(message = "You must provide a last name")
    @Size(max = 50)
    private String lastName;
    @NotEmpty(message = "You must provide a street")
    @Size(max = 50)
    private String street;
    @NotEmpty(message = "You must provide a city")
    @Size(max = 50)
    private String city;
    @NotEmpty(message = "You must provide a state")
    @Size(min = 2, max = 2, message = "State initials only")
    private String state;
    @NotEmpty(message = "You must provide a zip code")
    @Size(min = 5, max = 25, message = "Zip code has incorrect number of characters")
    private String postalCode;
    @NotEmpty(message = "You must provide a phone number")
    @Size(max = 15, message = "Phone number exceeds character limit")
    private String phone;
    @NotEmpty(message = "You must provide an email")
    @Size(max = 60, message = "Email exceeds character limit")
    private String email;

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return getAuthorID() == author.getAuthorID() &&
                Objects.equals(getFirstName(), author.getFirstName()) &&
                Objects.equals(getLastName(), author.getLastName()) &&
                Objects.equals(getStreet(), author.getStreet()) &&
                Objects.equals(getCity(), author.getCity()) &&
                Objects.equals(getState(), author.getState()) &&
                Objects.equals(getPostalCode(), author.getPostalCode()) &&
                Objects.equals(getPhone(), author.getPhone()) &&
                Objects.equals(getEmail(), author.getEmail());
    }

    @Override
    public int hashCode(){ return Objects.hash(getAuthorID(), getFirstName(), getLastName(), getStreet(), getCity(), getState(), getPostalCode(), getPhone(), getEmail());}

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
