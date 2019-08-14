package com.company.SaraMoujahedU1M5Summative.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Publisher {

    private int publisherID;
    @NotEmpty(message = "You must provide a publisher name")
    @Size(max = 50)
    private String name;
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
        Publisher publisher = (Publisher) o;
        return getPublisherID() == publisher.getPublisherID() &&
                Objects.equals(getName(), publisher.getName()) &&
                Objects.equals(getStreet(), publisher.getStreet()) &&
                Objects.equals(getCity(), publisher.getCity()) &&
                Objects.equals(getState(), publisher.getState()) &&
                Objects.equals(getPostalCode(), publisher.getPostalCode()) &&
                Objects.equals(getPhone(), publisher.getPhone()) &&
                Objects.equals(getEmail(), publisher.getEmail());
    }

    @Override
    public int hashCode(){ return Objects.hash(getPublisherID(), getName(), getStreet(), getCity(), getState(), getPostalCode(), getPhone(), getEmail());}

    public int getPublisherID() {
        return publisherID;
    }

    public void setPublisherID(int publisherID) {
        this.publisherID = publisherID;
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
