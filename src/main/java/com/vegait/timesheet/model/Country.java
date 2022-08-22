package com.vegait.timesheet.model;

import javax.persistence.Entity;

@Entity
public class Country extends Base {

    private String countryCode;

    public Country(String name, String countryCode) {
        super(name);
        this.countryCode = countryCode;
    }

    public Country() {

    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
