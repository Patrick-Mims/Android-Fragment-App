package edu.sfsu.classes.models;

import java.util.TimeZone;

public class Location {
    private String city;
    private String country;
    private int postcode;
    private String state;

    private Coordinates coordinates;
    private Street street;
    private Timezone timezone;

    public Location(String city, String country, int postcode, String state, Coordinates coordinates, Street street, Timezone timezone) {
        this.city = city;
        this.country = country;
        this.postcode = postcode;
        this.state = state;
        this.coordinates = coordinates;
        this.street = street;
        this.timezone = timezone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public Timezone getTimezone() {
        return timezone;
    }

    public void setTimezone(Timezone timezone) {
        this.timezone = timezone;
    }
}