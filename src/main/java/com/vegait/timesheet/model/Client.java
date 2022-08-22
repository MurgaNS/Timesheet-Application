package com.vegait.timesheet.model;

public class Client extends Base {
    private String address;
    private String city;
    private String postalCode;
    private Country country;

    public Client(String name, String address, String city, String postalCode, Country country) {
        super(name);
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    public Client() {

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
