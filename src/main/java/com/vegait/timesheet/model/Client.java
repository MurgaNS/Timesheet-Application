package com.vegait.timesheet.model;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column
    private String address;
    private String city;
    private Integer postal_code;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;


    public Client(Long id, String name, String address, String city, Integer postal_code, Country country) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.postal_code = postal_code;
        this.country = country;
    }

    public Client() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Integer getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(Integer postal_code) {
        this.postal_code = postal_code;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
