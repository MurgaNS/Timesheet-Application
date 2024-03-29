package com.vegait.timesheet.model.dto.request;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ClientRequest {

    @NotEmpty(message = "Name can not be null or empty, please enter correct name.")
    private String name;
    private String address;
    private String city;
    private String postalCode;
    @Valid
    @NotNull(message = "Please enter country fields")
    private CountryDetails country;
    @NotNull
    private Integer version;

    public String getName() {
        return name;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
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
