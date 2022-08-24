package com.vegait.timesheet.model.dto.request;

import javax.validation.constraints.NotBlank;

public class CountryDetails {

    @NotBlank

    private String countryCode;
    @NotBlank

    private String name;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
