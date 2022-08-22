package com.vegait.timesheet.model;

import lombok.Data;

import javax.persistence.*;

public class Country extends Base{

    private String countryCode;

    public Country(String countryCode) {
        super();
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
