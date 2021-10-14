package com.example.kinoticketreservierungssystem.entity;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import org.springframework.data.annotation.Id;

@Container(containerName = "Cinemas", ru = "400")
public class Cinema {
    @Id
    private String cinemaID;
    private String country;
    @PartitionKey
    private String state;
    private String street;
    private int houseNumber;
    private int postalNumber;
    private String businessEmail;
    private String businessPhoneNumber;

    public Cinema(String cinemaID, String country, String state, String street, int houseNumber, int postalNumber, String businessEmail, String businessPhoneNumber) {
        this.cinemaID = cinemaID;
        this.country = country;
        this.state = state;
        this.street = street;
        this.houseNumber = houseNumber;
        this.postalNumber = postalNumber;
        this.businessEmail = businessEmail;
        this.businessPhoneNumber = businessPhoneNumber;
    }


    public String getCinemaID() {
        return cinemaID;
    }

    public void setCinemaID(String cinemaID) {
        this.cinemaID = cinemaID;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getPostalNumber() {
        return postalNumber;
    }

    public void setPostalNumber(int postalNumber) {
        this.postalNumber = postalNumber;
    }

    public String getBusinessEmail() {
        return businessEmail;
    }

    public void setBusinessEmail(String businessEmail) {
        this.businessEmail = businessEmail;
    }

    public String getBusinessPhoneNumber() {
        return businessPhoneNumber;
    }

    public void setBusinessPhoneNumber(String businessPhoneNumber) {
        this.businessPhoneNumber = businessPhoneNumber;
    }
}