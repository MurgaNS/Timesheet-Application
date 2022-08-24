package com.vegait.timesheet.model.dto.request;

import javax.validation.constraints.NotEmpty;

public class CountryDetails {
    @NotEmpty(message = "Name can not be null or empty")
    private String countryCode;
    @NotEmpty(message = "Name can not be null or empty")
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
