package com.vegait.timesheet.model.dto.request;

public class ClientRequest {
    private String name;
    private String address;
    private String city;
    private String postalCode;
    private CountryDetails country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public CountryDetails getCountry() {
        return country;
    }

    public void setCountry(CountryDetails country) {
        this.country = country;
    }
}
