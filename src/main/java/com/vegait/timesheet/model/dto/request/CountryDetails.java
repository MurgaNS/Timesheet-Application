package com.vegait.timesheet.model.dto.request;

import javax.validation.constraints.NotEmpty;

public class CountryDetails {

    @NotEmpty(message = "Country code can not be null or empty, please enter correct country code")
    private String countryCode;
    @NotEmpty(message = "Country name can not be null or empty, please enter correct country name.")
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
